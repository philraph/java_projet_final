<%@ page import="net.efrei.java_projet_final.security.Group" %>
<%@ page import="java.util.Set" %>
<%@ page import="net.efrei.java_projet_final.entities.Ecole" %>
<%@ page import="net.efrei.java_projet_final.entities.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="net.efrei.java_projet_final.entities.Utilisateur" %>
<%@ page import="net.efrei.java_projet_final.entities.Enseignant" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Set<Group> userGroups = (Set<Group>) request.getAttribute("userGroups");
    Ecole ecole = (Ecole) request.getAttribute("ecole");
    List<Candidate> candidatures = (List<Candidate>) request.getAttribute("candidatures");

    List<Ecole> ecoles = (List<Ecole>) request.getAttribute("ecoles");
    List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("users");
    List<Enseignant> enseignants = (List<Enseignant>) request.getAttribute("enseignants");
    List<Candidate> candidats = (List<Candidate>) request.getAttribute("candidates");
%>

<!DOCTYPE html>
<html data-theme="dark">
<jsp:include page="/WEB-INF/components/partials/head.jsp"/>
<body>
<jsp:include page="/WEB-INF/components/partials/header.jsp"/>
<main class="container">
    <jsp:include page="/WEB-INF/components/partials/nav.jsp"/>
    <div role="document">
        <h3 class="mb-0">Bienvenue sur AMiRE !</h3>

        <% if (userGroups.contains(Group.ADMIN)) { %>
            <h1>Statistiques</h1>
            <div class="flex flex-wrap gap-4">
                <div class="basis-1/3-gap-4 stat-card">
                    <h4 class="mb-1">Ecoles</h4>
                    <p class="mb-0"><%= ecoles.size() %></p>
                </div>
                <div class="basis-1/3-gap-4 stat-card">
                    <h4 class="mb-1">Nombre d'utilisateurs</h4>
                    <p class="mb-0"><%= utilisateurs.size() %></p>
                </div>
                <div class="basis-1/3-gap-4 stat-card">
                    <h4 class="mb-1">Nombre d'enseignants</h4>
                    <p class="mb-0"><%= enseignants.size() %></p>
                </div>
                <div class="basis-1/3-gap-4 stat-card">
                    <h4 class="mb-1">Nombre de candidats</h4>
                    <p class="mb-0"><%= candidats.size() %></p>
                </div>
            </div>
        <% } %>

        <% if (userGroups.contains(Group.ECOLE)) { %>
            <h1>Candidatures pour <span class="text-primary"><%= ecole.getRaisonSociale() %></span></h1>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Nom</th>
                    <th scope="col">Prénom</th>
                    <th scope="col">Contact le</th>
                    <th scope="col">Par</th>
                    <th scope="col">Décision</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (Candidate candidature : candidatures) { %>
                    <tr>
                        <td><%= candidature.getIdEnseignant().getNom() %></td>
                        <td><%= candidature.getIdEnseignant().getPrenom() %></td>
                        <td><%= candidature.getContactLe() %></td>
                        <td><%= candidature.getContactPar() %></td>
                        <td><%= candidature.getDecision() %></td>
                        <td>
                            <a href="/candidature/<%= candidature.getId() %>" class="btn btn-primary">Voir</a>
                        </td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        <% } %>

        <% if (userGroups.contains(Group.ENSEIGNANT)) { %>
            <h1>Mes candidatures</h1>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Ecole</th>
                    <th scope="col">Contact le</th>
                    <th scope="col">Par</th>
                    <th scope="col">Décision</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (Candidate candidature : candidatures) { %>
                    <tr>
                        <td><%= candidature.getIdOffre().getIdEcole().getRaisonSociale() %></td>
                        <td><%= candidature.getContactLe() %></td>
                        <td><%= candidature.getContactPar() %></td>
                        <td><%= candidature.getDecision() %></td>
                        <td>
                            <a href="/candidature/<%= candidature.getId() %>" class="btn btn-primary">Voir</a>
                        </td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        <% } %>

        <jsp:include page="/WEB-INF/components/offers.jsp"/>
    </div>
</main>
</body>
</html>
