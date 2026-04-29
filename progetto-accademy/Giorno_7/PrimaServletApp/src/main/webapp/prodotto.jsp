<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Prodotto JSP</title>
</head>
<body>

<h1>Dettagli prodotto</h1>

<!-- 1. Creazione bean -->
<jsp:useBean id="prodotto" class="com.academy.javaclass.Prodotto" />

<!-- 2. Impostazione valori -->
<jsp:setProperty name="prodotto" property="nome" value="Laptop" />
<jsp:setProperty name="prodotto" property="prezzo" value="999.99" />

<!-- 3. Visualizzazione valori -->
<p>Nome: <jsp:getProperty name="prodotto" property="nome" /></p>
<p>Prezzo: <jsp:getProperty name="prodotto" property="prezzo" /> €</p>

</body>
</html>