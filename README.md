Primo progetto Git - Academy 2026
Storia del progetto

5fed935 (HEAD -> master, origin/master, origin/HEAD) Merge pull request #1 from Giovanni-Pacchiarotti/feature/saluto
1c78e23 (origin/feature/saluto, feature/saluto) Creato saluto.txt
a568adb Secondo commit
8d7bb6b Creato file README.md
92c781a Primo commit


Giorno 13:
GET http://localhost:8080/api/studenti
{
    "content": [
        {
            "cognome": "Rossi",
            "corsoLaurea": "Fisica",
            "dataNascita": "2000-01-10",
            "email": "mario@email.com",
            "id": 1,
            "nome": "Mario"
        },
        {
            "cognome": "Verdi",
            "corsoLaurea": "Matematica",
            "dataNascita": "1999-05-20",
            "email": "luigi@email.com",
            "id": 2,
            "nome": "Luigi"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "unpaged": false
    },
    "size": 20,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "totalElements": 2,
    "totalPages": 1
}



GET http://localhost:8080/api/studenti?page=0&size=2
{
    "content": [
        {
            "cognome": "Rossi",
            "corsoLaurea": "Fisica",
            "dataNascita": "2000-01-10",
            "email": "mario@email.com",
            "id": 1,
            "nome": "Mario"
        },
        {
            "cognome": "Verdi",
            "corsoLaurea": "Matematica",
            "dataNascita": "1999-05-20",
            "email": "luigi@email.com",
            "id": 2,
            "nome": "Luigi"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 2,
        "paged": true,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "unpaged": false
    },
    "size": 2,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "totalElements": 2,
    "totalPages": 1
}



GET http://localhost:8080/api/studenti?page=1&size=2
{
    "content": [],
    "empty": true,
    "first": false,
    "last": true,
    "number": 1,
    "numberOfElements": 0,
    "pageable": {
        "offset": 2,
        "pageNumber": 1,
        "pageSize": 2,
        "paged": true,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "unpaged": false
    },
    "size": 2,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "totalElements": 2,
    "totalPages": 1
}



GET http://localhost:8080/api/studenti?sort=cognome,asc
{
    "content": [
        {
            "cognome": "Rossi",
            "corsoLaurea": "Fisica",
            "dataNascita": "2000-01-10",
            "email": "mario@email.com",
            "id": 1,
            "nome": "Mario"
        },
        {
            "cognome": "Verdi",
            "corsoLaurea": "Matematica",
            "dataNascita": "1999-05-20",
            "email": "luigi@email.com",
            "id": 2,
            "nome": "Luigi"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 20,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 2,
    "totalPages": 1
}



GET http://localhost:8080/api/studenti?sort=nome,asc
{
    "content": [
        {
            "cognome": "Verdi",
            "corsoLaurea": "Matematica",
            "dataNascita": "1999-05-20",
            "email": "luigi@email.com",
            "id": 2,
            "nome": "Luigi"
        },
        {
            "cognome": "Rossi",
            "corsoLaurea": "Fisica",
            "dataNascita": "2000-01-10",
            "email": "mario@email.com",
            "id": 1,
            "nome": "Mario"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 20,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 2,
    "totalPages": 1
}



GET http://localhost:8080/api/studenti?sort=cognome,desc
{
    "content": [
        {
            "cognome": "Verdi",
            "corsoLaurea": "Matematica",
            "dataNascita": "1999-05-20",
            "email": "luigi@email.com",
            "id": 2,
            "nome": "Luigi"
        },
        {
            "cognome": "Rossi",
            "corsoLaurea": "Fisica",
            "dataNascita": "2000-01-10",
            "email": "mario@email.com",
            "id": 1,
            "nome": "Mario"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 20,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 2,
    "totalPages": 1
}



GET http://localhost:8080/api/studenti?page=0&size=2&sort=cognome,asc
{
    "content": [
        {
            "cognome": "Rossi",
            "corsoLaurea": "Fisica",
            "dataNascita": "2000-01-10",
            "email": "mario@email.com",
            "id": 1,
            "nome": "Mario"
        },
        {
            "cognome": "Verdi",
            "corsoLaurea": "Matematica",
            "dataNascita": "1999-05-20",
            "email": "luigi@email.com",
            "id": 2,
            "nome": "Luigi"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 2,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 2,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 2,
    "totalPages": 1
}



GET http://localhost:8080/api/studenti?page=1&size=1&sort=nome,desc
{
    "content": [
        {
            "cognome": "Verdi",
            "corsoLaurea": "Matematica",
            "dataNascita": "1999-05-20",
            "email": "luigi@email.com",
            "id": 2,
            "nome": "Luigi"
        }
    ],
    "empty": false,
    "first": false,
    "last": true,
    "number": 1,
    "numberOfElements": 1,
    "pageable": {
        "offset": 1,
        "pageNumber": 1,
        "pageSize": 1,
        "paged": true,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "unpaged": false
    },
    "size": 1,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "totalElements": 2,
    "totalPages": 2
}
