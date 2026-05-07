package com.academy.secondo_progetto.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	
	@ExceptionHandler(StudenteNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleStudenteNotFoundException(StudenteNotFoundException ex) 
	{
        Map<String, Object> errore = new HashMap<>();

        errore.put("errore", "Studente non trovato");

        // Estrazione ID dal messaggio dell'eccezione
        String messaggio = ex.getMessage();
        String id = messaggio.replaceAll("\\D+", "");

        errore.put("id", Long.parseLong(id));
        errore.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(errore, HttpStatus.NOT_FOUND);
    }

}
