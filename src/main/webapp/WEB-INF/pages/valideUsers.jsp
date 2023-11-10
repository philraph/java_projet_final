<%--
  Created by IntelliJ IDEA.
  User: aland
  Date: 10/11/2023
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="net.efrei.java_projet_final.entities.Utilisateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Utilisateur valides</title>
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <link rel="stylesheet" href="/resources/css/styles.css"/>
</head>
<body>

<h1>List of Valid Users</h1>

<ul>
    <c:forEach var="user" items="${validUsers}">
        <div>
            <h1>${user.username}</h1>
            <p>${user.id}</p>
        </div>
    </c:forEach>
</ul>

</body>
</html>



</body>
</html>
