// Variabili globali per memorizzare gli utenti e riferimenti agli elementi DOM
let allUsers = []; // Array per conservare tutti gli utenti recuperati
const userListContainer = document.getElementById('userList');
const searchInput = document.getElementById('searchInput');
const userDetailsModal = document.getElementById('userDetailsModal');
const modalUserDetails = document.getElementById('modalUserDetails');
const closeButton = document.querySelector('.modal .close-button');

/**
 * Funzione asincrona per recuperare gli utenti dall'API.
 * Gestisce anche gli errori di rete.
 */
async function fetchUsers() {
    userListContainer.innerHTML = '<p>Caricamento utenti...</p>'; // Messaggio di caricamento
    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/users');
        if (!response.ok) {
            // Se la risposta non è OK (es. 404, 500), lancia un errore
            throw new Error(`Errore HTTP! Stato: ${response.status}`);
        }
        allUsers = await response.json(); // Parsifica la risposta JSON
        renderUserList(allUsers); // Renderizza tutti gli utenti inizialmente
    } catch (error) {
        console.error("Errore durante il recupero degli utenti:", error);
        userListContainer.innerHTML = '<p>Impossibile caricare gli utenti. Riprova più tardi.</p>';
    }
}

/**
 * Funzione per renderizzare la lista degli utenti nel DOM.
 * @param {Array} usersToRender - L'array di utenti da visualizzare.
 */
function renderUserList(usersToRender) {
    userListContainer.innerHTML = ''; // Pulisce la lista precedente

    if (usersToRender.length === 0) {
        userListContainer.innerHTML = '<p>Nessun utente trovato con i criteri di ricerca.</p>';
        return;
    }

    usersToRender.forEach(user => {
        const userCard = document.createElement('div');
        userCard.classList.add('user-card');
        userCard.dataset.userId = user.id; // Memorizza l'ID utente per il click

        // Popola la card con i dati dell'utente
        userCard.innerHTML = `
            <h3>${user.name}</h3>
            <p><strong>Username:</strong> ${user.username}</p>
            <p><strong>Email:</strong> ${user.email}</p>
            <p><strong>Città:</strong> ${user.address.city}</p>
        `;

        // Aggiunge un listener per mostrare i dettagli al click sulla card
        userCard.addEventListener('click', () => showUserDetails(user.id));
        userListContainer.appendChild(userCard);
    });
}

/**
 * Funzione per filtrare gli utenti in base all'input di ricerca.
 * Il filtro è case-insensitive e cerca in nome, username ed email.
 */
function filterUsers() {
    const searchTerm = searchInput.value.toLowerCase();
    const filteredUsers = allUsers.filter(user =>
        user.name.toLowerCase().includes(searchTerm) ||
        user.username.toLowerCase().includes(searchTerm) ||
        user.email.toLowerCase().includes(searchTerm)
    );
    renderUserList(filteredUsers);
}

/**
 * Funzione asincrona per mostrare i dettagli di un utente specifico in una modale.
 * Recupera i dettagli completi dell'utente dall'API.
 * @param {number} userId - L'ID dell'utente di cui mostrare i dettagli.
 */
async function showUserDetails(userId) {
    modalUserDetails.innerHTML = '<p>Caricamento dettagli utente...</p>';
    userDetailsModal.style.display = 'flex'; // Mostra la modale con messaggio di caricamento

    try {
        const response = await fetch(`https://jsonplaceholder.typicode.com/users/${userId}`);
        if (!response.ok) {
            throw new Error(`Errore HTTP! Stato: ${response.status}`);
        }
        const user = await response.json();

        // Popola la modale con i dettagli completi dell'utente
        modalUserDetails.innerHTML = `
            <p><strong>Nome Completo:</strong> ${user.name}</p>
            <p><strong>Username:</strong> ${user.username}</p>
            <p><strong>Email:</strong> <a href="mailto:${user.email}">${user.email}</a></p>
            <p><strong>Telefono:</strong> ${user.phone}</p>
            <p><strong>Sito Web:</strong> <a href="http://${user.website}" target="_blank">${user.website}</a></p>
            <p><strong>Azienda:</strong> ${user.company.name}</p>
            <p><strong>Indirizzo:</strong> ${user.address.street}, ${user.address.suite}, ${user.address.city}, ${user.address.zipcode}</p>
        `;
    } catch (error) {
        console.error(`Errore durante il recupero dei dettagli utente ${userId}:`, error);
        modalUserDetails.innerHTML = '<p>Impossibile caricare i dettagli dell\'utente.</p>';
    }
}

// --- Event Listeners ---

// Carica gli utenti non appena il DOM è completamente caricato
document.addEventListener('DOMContentLoaded', fetchUsers);

// Filtra gli utenti ogni volta che l'utente digita nell'input di ricerca
searchInput.addEventListener('input', filterUsers);

// Chiude la modale quando si clicca sul pulsante di chiusura (X)
closeButton.addEventListener('click', () => {
    userDetailsModal.style.display = 'none';
});

// Chiude la modale quando si clicca al di fuori del suo contenuto
window.addEventListener('click', (event) => {
    if (event.target === userDetailsModal) {
        userDetailsModal.style.display = 'none';
    }
});
