<%@ page import="net.efrei.java_projet_final.entities.Ecole, net.efrei.java_projet_final.entities.Offre" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Écoles et Offres</title>
    <link rel='stylesheet' href='https://picocss.com/docs/css/pico.docs.min.css'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
</head>
<body>

<%
    List<Ecole> ecoles = (List<Ecole>) request.getAttribute("schools");
    if (ecoles == null || ecoles.isEmpty()) {
%>
<p>Aucune école n'existe actuellement</p>
<%
} else {
%>
<% for (Ecole ecole : ecoles) { %>

<div class="school_block" style="padding: 20px">
    <p style="font-size: large">➤ <%= ecole.getRaisonSociale() %> <a href="/schools/<%=ecole.getId()%>">(Voir les détails)</a></p>
    <% if (!ecole.getOffres().isEmpty()) { %>
    <%=ecole.getOffres().size()%> offre<%= ecole.getOffres().size() > 1 ? "s" : "" %> disponible<%= ecole.getOffres().size() > 1 ? "s" : "" %>
    <ul>
        <% for (Offre offre : ecole.getOffres()) { %>
        <li><%= offre.getIntitule() %> - <span style="color: green"><%= offre.getCandidates().size()%> candidat<%= offre.getCandidates().size() > 1 ? "s" : "" %></span></li>
        <% } %>
    </ul>

    <% } %>
    <% } %>
</div>
<hr>
<% } %>
</body>
</html>