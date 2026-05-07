package com.academy.secondo_progetto.exception;

public class StudenteNotFoundException extends RuntimeException
{
	
	public StudenteNotFoundException(int id) 
	{
        super("Studente con ID " + id + " non trovato");
    }
}
