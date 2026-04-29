package com.academy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BenvenutoServlet
 */
public class BenvenutoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private int contatore = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenvenutoServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException 
	{
	    System.out.println(">>> INIT: Servlet avviata");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    	String nome = request.getParameter("nome");
    	if (nome == null || nome.isEmpty())
    	    nome = "ospite";
    	
    	contatore++;

        response.setContentType("text/html");

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Ciao, " + nome + "!</h1>");
        response.getWriter().println("<h1>Ciao! Questa è la mia prima Servlet.</h1>");
        response.getWriter().println("<p>Numero di visite: " + contatore + "</p>");
        response.getWriter().println("</body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void destroy() 
	{
	    System.out.println(">>> DESTROY: Servlet terminata");
	}

}
