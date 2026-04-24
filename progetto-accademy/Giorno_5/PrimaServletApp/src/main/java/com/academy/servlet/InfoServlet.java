package com.academy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
public class InfoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {

        response.setContentType("text/html");

        response.getWriter().println("<html><body>");

        // Metodo HTTP
        response.getWriter().println("<h2>Metodo HTTP:</h2>");
        response.getWriter().println("<p>" + request.getMethod() + "</p>");

        // URL completa
        response.getWriter().println("<h2>URL richiesta:</h2>");
        response.getWriter().println("<p>" + request.getRequestURL() + "</p>");

        // Parametri
        response.getWriter().println("<h2>Parametri:</h2>");

        java.util.Enumeration<String> parametri = request.getParameterNames();

        if(!parametri.hasMoreElements())
            response.getWriter().println("<p>Nessun parametro ricevuto</p>");

        while (parametri.hasMoreElements()) 
        {
            String nome = parametri.nextElement();
            String valore = request.getParameter(nome);

            response.getWriter().println("<p>" + nome + " = " + valore + "</p>");
        }

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

}
