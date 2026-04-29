<%-- 
    Questa pagina mostra un messaggio di benvenuto
    insieme alla data e ora correnti generate dinamicamente
    usando Java (LocalDateTime) dentro uno scriptlet JSP.
--%>

<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
    <title>Benvenuto</title>
</head>
<body>

<%
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String formattedDate = now.format(formatter);
%>

<h1>Benvenuto!</h1>
<p>Data e ora correnti: <%= formattedDate %></p>

</body>
</html>