<%-- 
    Questa pagina legge due parametri dalla URL (num1 e num2),
    li somma e mostra il risultato.
    Include dinamicamente un footer tramite JSP Action <jsp:include>.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Calcolatrice JSP</title>
</head>
<body>

<h1>Calcolatrice</h1>

<%
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");

    if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
%>

    <p>Inserisci i parametri nell'URL.</p>
    <p>Esempio: calcolatrice.jsp?num1=5&num2=3</p>

<%
    } else {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int somma = a + b;
%>

    <p><%= a %> + <%= b %> = <%= somma %></p>

<%
    }
%>

<jsp:include page="footer.jsp" />

</body>
</html>