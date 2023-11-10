
<%--
  Created by IntelliJ IDEA.
  User: jl142
  Date: 07/11/2023
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="net.efrei.java_projet_final.entities.Utilisateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Admin panel confirm registerd account</title>
  <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
  <link rel="stylesheet" href="/resources/css/styles.css"/>
</head>
<body>
<%
  List<Utilisateur> users = (List<Utilisateur>) request.getAttribute("users");
  if (users == null){
%>
<h1>Aucun utilisateur a confirmer !</h1>
<%
} else {
%>

<div class="container">
  <h2>Liste des utilisateurs non-valide</h2>
  <table role="grid">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Username</th>
      <th scope="col">Type</th>
      <th scope="col">Validation</th>
    </tr>
    </thead>
    <tbody>
    <% for (Utilisateur user : users) {%>

    <tr>

      <th scope="row"><%= user.getId() %></th>
      <td><%= user.getUsername() %></td>
      <%
        if (user.getEcole() != null) { %><td>Ecole</td>
      <%}
      else {%>
      <td>Enseignant</td>
      <% }%>
      <td>
        <form action="adminConfirmAccount" method="post">
          <input type="hidden" name="userId" value="<%= user.getId() %>">
          <button type="submit" name="action" value="validate">Valider</button>
        </form>
      </td>
    </tr>

    <% } %>
    </tbody>
  </table>

</div>
<% } %>
</body>
</html>
