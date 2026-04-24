package com.academy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MaintenanceFilter implements Filter 
{
	
	private static final boolean IN_MANUTENZIONE = false;


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getRequestURI();

        if(IN_MANUTENZIONE && !path.contains("/manutenzione")) 
        {
        	res.sendRedirect(req.getContextPath() + "/manutenzione");
            return;
        }

        chain.doFilter(request, response);
	}

}
