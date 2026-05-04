package com.academy.primo_progetto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.primo_progetto.component.ContatoreBeanSingleton;

@RestController
public class ContatoreController 
{
	
	private final ContatoreBeanSingleton contatoreBean;
	
	public ContatoreController(ContatoreBeanSingleton contatoreBean) 
    {
        this.contatoreBean = contatoreBean;
    }

    @GetMapping("/contatore")
    public int incrementa() 
    {
        return contatoreBean.incrementa();
    }

}
