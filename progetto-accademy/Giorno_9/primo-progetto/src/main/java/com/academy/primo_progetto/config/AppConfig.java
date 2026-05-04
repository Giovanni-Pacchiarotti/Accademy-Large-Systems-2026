package com.academy.primo_progetto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppConfig 
{
	
	@Value("${app.nome}")
    private String appNome;

    @Value("${app.versione}")
    private String appVersione;

    @Value("${app.messaggio-benvenuto}")
    private String messaggioBenvenuto;

    @Value("${server.port}")
    private String serverPort;

    @PostConstruct
    public void stampaConfigurazione() 
    {
        System.out.println("=== CONFIGURAZIONE APPLICAZIONE ===");
        System.out.println("Nome App: " + appNome);
        System.out.println("Versione: " + appVersione);
        System.out.println("Messaggio: " + messaggioBenvenuto);
        System.out.println("Porta server: " + serverPort);
        System.out.println("===================================");
    }

}
