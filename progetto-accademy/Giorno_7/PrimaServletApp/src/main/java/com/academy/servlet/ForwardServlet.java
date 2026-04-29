package com.academy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/azione-forward")
public class ForwardServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// FORWARD:
        // - La richiesta NON cambia dal punto di vista del browser
        // - Il server inoltra internamente la richiesta ad un'altra risorsa
        // - NON viene creata una nuova richiesta HTTP
        // - L'URL nel browser resta lo stesso (/azione-forward)
        request.getRequestDispatcher("/destinazione").forward(request, response);

        // Uso tipico:
        // - passaggio tra componenti interni (Servlet → JSP o Servlet → Servlet)
        // - quando NON vuoi che il client veda il cambio di pagina
        // - quando vuoi mantenere request attributes (dati temporanei)
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
