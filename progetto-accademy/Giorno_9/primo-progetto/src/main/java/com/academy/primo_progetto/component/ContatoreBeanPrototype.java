package com.academy.primo_progetto.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ContatoreBeanPrototype 
{
	
	private int contatore = 0;

    public int incrementa() 
    {
        return ++contatore;
    }

}
