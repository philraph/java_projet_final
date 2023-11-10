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

<div>
  <div class="form-group">
    <label for="intitule">Titre du besoin</label>
    <input type="text" id="intitule" name="intitule" value="<%= offre.getIntitule() %>" required>
  </div>

  <div class="form-group">
    <label for="exigence">Exigences du poste</label>
    <textarea placeholder="Exigences : visio, experience..." id="exigence" name="exigences"><%= offre.getExigences() %></textarea><br>
  </div>

  <div class="form-group">
    <textarea placeholder="remarque..." aria-label="Remarques" id="remarque" name="remarques"><%= offre.getRemarques() %></textarea><br>
  </div>

  <div class="form-group">
    <label for="dateDebut">Date de debut du besoin</label>
    <input type="date" id="dateDebut" name="dateDebut" value="<%= offre.getIdDispo().getDateDebut() %>" required aria-label="Date" />
  </div>
  <div class="form-group">
    <label for="dateFin">Date de fin du besoin</label>
    <input type="date" id="dateFin" name="dateFin" value="<%= offre.getIdDispo().getDateFin() %>" required aria-label="Date" />
  </div>
</div>
