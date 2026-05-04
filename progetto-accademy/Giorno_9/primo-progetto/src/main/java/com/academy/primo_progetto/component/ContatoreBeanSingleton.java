package com.academy.primo_progetto.component;

import org.springframework.stereotype.Component;

@Component
public class ContatoreBeanSingleton 
{
	
	private int contatore = 0;
	
	public int incrementa()
	{
		return ++contatore;
	}

}
