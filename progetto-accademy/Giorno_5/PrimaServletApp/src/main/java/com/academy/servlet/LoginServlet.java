package com.academy.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException 
    {
        String errore = request.getParameter("errore");

        response.setContentType("text/html");

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Login</h2>");

        if("1".equals(errore)) 
            response.getWriter().println("<p style='color:red;'>Credenziali non valide. Riprova.</p>");

        response.getWriter().println
        (
            "<form method='POST' action='login'>" 									+
            "<input name='username' placeholder='Username' />" 						+
            "<input type='password' name='password' placeholder='Password' />" 		+
            "<button type='submit'>Accedi</button>" 								+
            "</form>"
        );

        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if("admin".equals(username) && "1234".equals(password)) 
        {
            HttpSession session = request.getSession(true);
            
            session.setAttribute("username", username);

            response.sendRedirect(request.getContextPath() + "/dashboard");
        } 
        else 
            response.sendRedirect("login?errore=1");
    }
}
