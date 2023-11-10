<%@ page import="net.efrei.java_projet_final.entities.Utilisateur" %>
<%@ page import="net.efrei.java_projet_final.security.Group" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    Utilisateur user = (Utilisateur) request.getAttribute("user");
    Set<Group> groups = (Set<Group>) request.getAttribute("userGroups");
    String firstGroup = groups.stream().findFirst().get().getDisplayName();
%>

<nav class="container-fluid">
    <ul>
        <li></li>
        <li>
            AMiRE
        </li>
    </ul>
    <ul>
        <li>
            <a class="secondary" href="dashboard"><%= user.getUsername() %> (<%= firstGroup %>)</a>
        </li>
        <li>
            <a class="secondary" href="logout">Se déconnecter</a>
        </li>
    </ul>
</nav>