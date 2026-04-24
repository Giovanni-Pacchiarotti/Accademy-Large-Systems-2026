package com.academy.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoggingFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;

        String timestamp = LocalDateTime.now().toString();
        String method = req.getMethod();
        String url = req.getRequestURL().toString();
        long start = System.currentTimeMillis();

        System.out.println("[" + timestamp + "] " + method + " " + url);

        chain.doFilter(request, response);
        
        long end = System.currentTimeMillis();
        
        long duration = end - start;
        
        System.out.println("Tempo di esecuzione: " + duration + " ms");
	}

}
