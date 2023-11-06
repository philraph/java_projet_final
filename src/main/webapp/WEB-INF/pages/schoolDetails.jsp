<%@ page import="net.efrei.java_projet_final.entities.Ecole" %>
<%@ page import="net.efrei.java_projet_final.entities.Offre" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="net.efrei.java_projet_final.entities.Competence" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails de l'École</title>
    <link rel='stylesheet' href='https://picocss.com/docs/css/pico.docs.min.css'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
</head>
<body>

<% Ecole ecole = (Ecole) request.getAttribute("school"); %>

<div>
    <h1>Détails de l'École</h1>
    <p>ID: <%= ecole.getId() %>
    </p>
    <p>Raison sociale: <%= ecole.getRaisonSociale() %>
    </p>
    <p>Offres :
    <ul>
        <% for (Offre offre : ecole.getOffres()) { %>
        <li>
            ID Offre: <%= offre.getId() %>
            Détails Offre: <%= offre.getExigences() %>
            Nombre candidats: <%= offre.getCandidates().size() %>
            Compétences requises: <%= offre.getCompetences().stream().map(Competence::getCompetence).collect(Collectors.joining(", ")) %>
        </li>
        <% } %>
    </ul>
    </p>
    </p>
</div>

</body>
</html>
