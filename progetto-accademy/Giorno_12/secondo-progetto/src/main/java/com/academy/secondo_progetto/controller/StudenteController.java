package com.academy.secondo_progetto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
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
        Studente studente = service.findById(id);

        return ResponseEntity.ok(studente);
        
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
		Studente studente = service.findById(id);

	    studente.setNome(s.getNome());
	    studente.setCognome(s.getCognome());
	    studente.setEmail(s.getEmail());
	    studente.setDataNascita(s.getDataNascita());
	    studente.setCorsoLaurea(s.getCorsoLaurea());

	    Studente aggiornato = service.save(studente);

	    return ResponseEntity.ok(aggiornato);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudente(@PathVariable int id) 
	{
	    service.findById(id);
	    service.delete(id);
	    
	    return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/cerca")
    public List<Studente> findByCognome(@RequestParam String cognome) 
	{
        return service.findByCognome(cognome);
    }
	
	@GetMapping("/{id}/corso")
	public ResponseEntity<Map<String, String>> getCorsoDiLaurea(@PathVariable int id)
	{
	    Studente studente = service.findById(id);

	    Map<String, String> response = new HashMap<>();
	    response.put("corsoDiLaurea", studente.getCorsoLaurea());

	    return ResponseEntity.ok(response);
	}

}
