Collection dei 5 endpoint del progetto:



GET http://localhost:8080/api/studenti=

\[{"cognome":"Rossi","corsoLaurea":"Fisica","dataNascita":"2000-01-10","email":"mario@email.com","id":1,"nome":"Mario"},{"cognome":"Verdi","corsoLaurea":"Matematica","dataNascita":"1999-05-20","email":"luigi@email.com","id":2,"nome":"Luigi"}]



GET http://localhost:8080/api/studenti/1=

{"cognome":"Rossi","corsoLaurea":"Fisica","dataNascita":"2000-01-10","email":"mario@email.com","id":1,"nome":"Mario"}



POST http://localhost:8080/api/studenti=

201 Created

{

&#x20;   "cognome": "Neri",

&#x20;   "corsoLaurea": "Informatica",

&#x20;   "dataNascita": "2000-05-10",

&#x20;   "email": "marco@email.com",

&#x20;   "id": 4,

&#x20;   "nome": "Marco"

}



PUT http://localhost:8080/api/studenti/1=

200 OK

{

&#x20;   "cognome": "Rossi",

&#x20;   "corsoLaurea": "Fisica",

&#x20;   "dataNascita": "2000-01-10",

&#x20;   "email": "mario@nuovaemail.com",

&#x20;   "id": 1,

&#x20;   "nome": "Mario"

}



DELETE http://localhost:8080/api/studenti/1=

204 No Content



