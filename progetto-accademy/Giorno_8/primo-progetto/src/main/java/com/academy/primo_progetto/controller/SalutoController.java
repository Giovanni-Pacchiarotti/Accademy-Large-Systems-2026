package com.academy.primo_progetto.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutoController 
{
	
	@Value("${app.nome}")
    private String appNome;

    @Value("${app.versione}")
    private String appVersione;

    @Value("${app.messaggio-benvenuto}")
    private String messaggioBenvenuto;
    
    @Value("${server.port}")
    private String serverPort;

	@GetMapping("/saluto")
    public String saluto() 
	{
		return "Ciao dal mio primo Spring Boot!!!";
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
