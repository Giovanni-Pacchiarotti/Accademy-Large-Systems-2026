package com.academy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EchoServlet
 */
@WebServlet("/echo")
public class EchoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String testo = request.getParameter("testo");

        request.setAttribute("testoRicevuto", testo);

        response.setContentType("text/html");

        response.getWriter().println("Testo ricevuto: " + testo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	/*
	SCOPE UTILIZZATI:

	1. REQUEST:
	   - Dura una singola richiesta HTTP
	   - Usato per dati temporanei (es. form, parametri)
	   - Esempio: EchoServlet

	2. SESSION:
	   - Dura per uno specifico utente
	   - Usato per login, carrello, preferenze
	   - Esempio: ContatoreUtenteServlet

	3. APPLICATION:
	   - Dura per tutta l'applicazione
	   - Condiviso tra tutti gli utenti
	   - Esempio: ContatorePaginaServlet
	*/

}
