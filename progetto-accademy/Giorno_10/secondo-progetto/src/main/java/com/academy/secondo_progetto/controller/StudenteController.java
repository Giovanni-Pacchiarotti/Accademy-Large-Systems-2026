package com.academy.secondo_progetto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.secondo_progetto.entities.Studente;
import com.academy.secondo_progetto.service.StudenteService;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController 
{
	
	@Autowired
    private StudenteService service;
	
	@GetMapping
    public List<Studente> getAllStudenti() 
	{
        return service.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Studente> getStudenteById(@PathVariable int id) 
	{
        Optional<Studente> studente = service.findById(id);

        if(studente.isPresent())
            return ResponseEntity.ok(studente.get());
        else
            return ResponseEntity.notFound().build();
        
    }
	
	@PostMapping
	public ResponseEntity<Studente> createStudente(@RequestBody Studente s) 
	{
	    Studente salvato = service.save(s);

	    return ResponseEntity.status(HttpStatus.CREATED).body(salvato);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Studente> updateStudente
		(
	        @PathVariable int id,
	        @RequestBody Studente s
	    ) 
	{
	    Optional<Studente> esistente = service.findById(id);

	    if(esistente.isPresent()) 
	    {
	        Studente studente = esistente.get();

	        // aggiorna i campi
	        studente.setNome(s.getNome());
	        studente.setCognome(s.getCognome());
	        studente.setEmail(s.getEmail());
	        studente.setDataNascita(s.getDataNascita());
	        studente.setCorsoLaurea(s.getCorsoLaurea());

	        Studente aggiornato = service.save(studente);

	        return ResponseEntity.ok(aggiornato);
	    } 
	    else 
	    {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudente(@PathVariable int id) 
	{
	    Optional<Studente> studente = service.findById(id);

	    if(studente.isPresent()) 
	    {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    } 
	    else 
	    {
	        return ResponseEntity.notFound().build();
	    }
	}

}
