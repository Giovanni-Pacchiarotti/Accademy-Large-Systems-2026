\# API Studenti - Sicurezza Endpoint



\## Tabella accessi API



| Metodo HTTP | Endpoint | Accesso |

|---|---|---|

| GET | /api/studenti | USER, ADMIN |

| GET | /api/studenti/{id} | USER, ADMIN |

| GET | /api/studenti/cerca?cognome=... | USER, ADMIN |

| GET | /api/studenti/{id}/corso | USER, ADMIN |

| POST | /api/studenti | ADMIN |

| PUT | /api/studenti/{id} | ADMIN |

| DELETE | /api/studenti/{id} | ADMIN |



\---



\## Utenti configurati



\### ADMIN



\- Username: `admin`

\- Password: `admin123`



Permessi:

\- GET

\- POST

\- PUT

\- DELETE



\---



\### USER



\- Username: `user`

\- Password: `user123`



Permessi:

\- solo GET



\---



\## Sicurezza utilizzata



\- Spring Security

\- HTTP Basic Authentication

\- Password criptate con BCrypt

\- CSRF disabilitato per API REST

