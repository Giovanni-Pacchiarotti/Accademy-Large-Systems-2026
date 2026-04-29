package com.academy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.javaclass.Prodotto;

/**
 * Servlet implementation class ProdottiServlet
 */
@WebServlet("/prodotti")
public class ProdottiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Prodotto> prodotti = new ArrayList<>();

        Prodotto p1 = new Prodotto();
        p1.setNome("Laptop");
        p1.setPrezzo(999.99);
        p1.setDisponibile(true);

        Prodotto p2 = new Prodotto();
        p2.setNome("Mouse");
        p2.setPrezzo(25.50);
        p2.setDisponibile(true);

        Prodotto p3 = new Prodotto();
        p3.setNome("Tastiera");
        p3.setPrezzo(45.00);
        p3.setDisponibile(false);

        Prodotto p4 = new Prodotto();
        p4.setNome("Monitor");
        p4.setPrezzo(199.99);
        p4.setDisponibile(true);

        Prodotto p5 = new Prodotto();
        p5.setNome("Stampante");
        p5.setPrezzo(120.00);
        p5.setDisponibile(false);

        prodotti.add(p1);
        prodotti.add(p2);
        prodotti.add(p3);
        prodotti.add(p4);
        prodotti.add(p5);

        request.setAttribute("listaProdotti", prodotti);

        request.getRequestDispatcher("lista-prodotti.jsp")
               .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
