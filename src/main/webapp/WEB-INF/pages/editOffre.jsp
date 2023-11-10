<%@ page import="net.efrei.java_projet_final.entities.Offre" %><%--
  Created by IntelliJ IDEA.
  User: jl142
  Date: 20/10/2023
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%
    Offre offre = (Offre) request.getAttribute("offre");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Create Offre</title>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css"/>
</head>
<body>

<div class="container">
    <h2>Étider une offre</h2>
    <form action="/edit/offres/"<%= offre.getId() %>"" method="post">

        <jsp:include page="/WEB-INF/components/editOffre.jsp"/>

        <button type="submit">Éditer l'offre</button>

    </form>
</div>

</body>
</html>
