package com.academy.secondo_progetto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.secondo_progetto.entities.Studente;
import com.academy.secondo_progetto.exception.StudenteNotFoundException;
import com.academy.secondo_progetto.repositories.StudenteRepository;

@Service
public class StudenteService 
{
	@Autowired
    private StudenteRepository repository;
	
	// READ
	public List<Studente> findAll() 
	{
	    return repository.findAll();
	}
	
	public Studente findById(int id) 
	{
		return repository.findById(id)
				.orElseThrow(() -> new StudenteNotFoundException(id));
	}

    // CREATE
    public Studente save(Studente s) 
    {
        return repository.save(s);
    }

    // UPDATE
    public Studente update(Studente s) 
    {
        return repository.save(s);
    }
    
    // DELETE
    public void delete(int id)
    {
    	Studente s = repository.findById(id)
    			.orElseThrow(() -> new StudenteNotFoundException(id));
    			
    	repository.delete(s);
    }
    
    public List<Studente> getByCorso(String corso) 
    {
        return repository.findByCorsoLaurea(corso);
    }
    
    public List<Studente> findByCognome(String cognome) 
    {
        return repository.findByCognome(cognome);
    }

}
