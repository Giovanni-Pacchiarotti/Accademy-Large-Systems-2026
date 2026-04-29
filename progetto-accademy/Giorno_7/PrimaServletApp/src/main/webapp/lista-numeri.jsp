<%-- 
    Questa pagina genera una lista HTML (<ul>) con i numeri da 1 a 10
    utilizzando un ciclo for scritto all'interno di uno scriptlet JSP.
    Inoltre include una intestazione da header.jsp.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>

<ul>
<%
    for (int i = 1; i <= 10; i++) {
%>
    <li><%= i %></li>
<%
    }
%>
</ul>

</body>
</html>