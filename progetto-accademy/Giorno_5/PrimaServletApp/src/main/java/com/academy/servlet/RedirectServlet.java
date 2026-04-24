package com.academy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/azione-redirect")
public class RedirectServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// REDIRECT:
        // - Il server dice al browser di fare una NUOVA richiesta HTTP
        // - Il browser cambia URL
        // - Vengono fatte 2 richieste:
        //   1) /azione-redirect
        //   2) /destinazione
        response.sendRedirect("/destinazione");

        // Uso tipico:
        // - dopo un login (pattern Post/Redirect/Get)
        // - dopo invio form (evita duplicazione submit con refresh)
        // - quando vuoi cambiare realmente URL nel browser
        // - quando passi a una risorsa esterna o pubblica
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
