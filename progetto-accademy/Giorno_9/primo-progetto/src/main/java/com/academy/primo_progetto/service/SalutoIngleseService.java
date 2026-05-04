package com.academy.primo_progetto.service;

import org.springframework.stereotype.Service;

@Service
public class SalutoIngleseService implements SalutoService {

	@Override
	public String getSaluto() 
	{
		return "Good morning!";
	}

}
