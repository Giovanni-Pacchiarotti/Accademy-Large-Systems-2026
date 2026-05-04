package com.academy.primo_progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.primo_progetto.service.SalutoService;

@RestController
public class SalutoController 
{
	
	/*
	 Differenze tra @Primary e @Qualifier:
	 - @Primary indica a Spring quale bean usare di default quando esistono più implementazioni dello stesso tipo.
	 - @Qualifier permette di scegliere esplicitamente quale bean iniettare, specificandone il nome.
	 - In pratica: @Primary = scelta automatica di default, @Qualifier = scelta manuale e precisa.

	 Differenze tra scope singleton e prototype:
	 - Singleton (default): viene creata UNA sola istanza del bean per tutta l'applicazione.
	   Tutti i componenti condividono lo stesso oggetto (stato condiviso tra richieste).
	 - Prototype: viene creata una NUOVA istanza ogni volta che il bean viene richiesto al container.
	   Tuttavia, se iniettato in un bean singleton, viene istanziato una sola volta al momento dell'iniezione.
	*/
	
	@Value("${app.nome}")
    private String appNome;

    @Value("${app.versione}")
    private String appVersione;

    @Value("${app.messaggio-benvenuto}")
    private String messaggioBenvenuto;
    
    @Value("${server.port}")
    private String serverPort;
    
    private final SalutoService salutoService;
    
    @Autowired
    public SalutoController(@Qualifier("salutoIngleseService") SalutoService salutoService) 
    {
        this.salutoService = salutoService;
    }
    
	@GetMapping("/saluto")
    public String saluto() 
	{
		return salutoService.getSaluto();
    }
	
	@GetMapping("/info")
    public String info() 
	{
		return "{\"autore\": \"Giovanni Pacchiarotti\"}";
    }
	
	@GetMapping("/app-info")
	public String appInfo() 
	{
	    return 	"App: " 			+ appNome 				+ 
	    		", Versione: " 		+ appVersione 			+  
	    		", Messaggio: " 	+ messaggioBenvenuto	;
	}
	
	@GetMapping("/configurazione-server")
	public String configurazioneServer() 
	{
	    return "Il server è in ascolto sulla porta: " + serverPort;
	}
	
}
