<%@ page import="net.efrei.java_projet_final.entities.Ecole" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Écoles</title>
    <link rel='stylesheet' href='https://picocss.com/docs/css/pico.docs.min.css'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
</head>
<body>

<%
    List<Ecole> ecoles = (List<Ecole>) request.getAttribute("school");
    if (ecoles == null || ecoles.isEmpty()) {
%>
<p>Aucune école</p>
<%
} else {
%>
<table role="grid">
    <thead>
    <tr>
        <th>ID</th>
        <th>Raison Sociale</th>
    </tr>
    </thead>
    <tbody>
    <% for (Ecole ecole : ecoles) { %>
    <tr>
        <td><%= ecole.getId() %>
        </td>
        <td><%= ecole.getRaisonSociale() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<%
    }
%>

</body>
</html>