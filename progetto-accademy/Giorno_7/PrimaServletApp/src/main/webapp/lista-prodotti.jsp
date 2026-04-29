<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista Prodotti</title>
</head>
<body>

<h1>Prodotti</h1>

<table border="1">
    <tr>
        <th>Nome</th>
        <th>Prezzo</th>
        <th>Stato</th>
        <th>Categoria</th>
    </tr>

    <c:forEach var="p" items="${listaProdotti}">

        <tr>
            <td>${p.nome}</td>
            <td>${p.prezzo} €</td>

            <!-- STATO -->
            <td>
                <c:if test="${p.disponibile}">
                    <span style="color:green">Disponibile</span>
                </c:if>

                <c:if test="${!p.disponibile}">
                    <span style="color:red">Non disponibile</span>
                </c:if>
            </td>

            <!-- CATEGORIA PREZZO -->
            <td>
                <c:choose>
                    <c:when test="${p.prezzo < 20}">
                        Economico
                    </c:when>

                    <c:when test="${p.prezzo <= 100}">
                        Medio
                    </c:when>

                    <c:otherwise>
                        Costoso
                    </c:otherwise>
                </c:choose>
            </td>

        </tr>

    </c:forEach>

</table>

</body>
</html>