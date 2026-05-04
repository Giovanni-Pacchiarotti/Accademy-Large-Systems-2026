package com.academy.primo_progetto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.primo_progetto.component.ContatoreBeanPrototype;

@RestController
public class ContatorePrototypeController 
{

	private final ContatoreBeanPrototype contatoreBean;

    public ContatorePrototypeController(ContatoreBeanPrototype contatoreBean) 
    {
        this.contatoreBean = contatoreBean;
    }

    @GetMapping("/contatore-prototype")
    public int incrementa() 
    {
        return contatoreBean.incrementa();
    }
}
