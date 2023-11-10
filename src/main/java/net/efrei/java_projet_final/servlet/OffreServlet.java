package net.efrei.java_projet_final.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import net.efrei.java_projet_final.entities.Disponibilite;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Offre;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.security.Group;
import net.efrei.java_projet_final.security.Protected;
import net.efrei.java_projet_final.services.DisponibiliteService;
import net.efrei.java_projet_final.services.OffreService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/create/offres")
@Protected(Group.ECOLE)
public class OffreServlet extends HttpServlet {

    @Inject
    private OffreService _offreService;

    @Inject
    private DisponibiliteService _disponibiliteService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/createOffre.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve form data from the request
        String intitule = request.getParameter("intitule");
        String exigences = request.getParameter("exigences");
        String remarques = request.getParameter("remarques");
        String dateDebut = request.getParameter("dateDebut");
        String  dateFin = request.getParameter("dateFin");

        Utilisateur user = (Utilisateur) request.getAttribute("user");

        Ecole ecole = user.getEcole();

        Disponibilite disponibilite = new Disponibilite();

        disponibilite.setDateDebut(LocalDate.parse(dateDebut));
        disponibilite.setDateFin(LocalDate.parse(dateFin));

        _disponibiliteService.create(disponibilite);

        // Create a new Offre entity
        Offre offre = new Offre();
        offre.setIntitule(intitule);
        offre.setExigences(exigences);
        offre.setRemarques(remarques);
        offre.setIdEcole(ecole);

        // Save the new Offre entity
        _offreService.create(offre);

        // Redirect to a success page
        response.sendRedirect(request.getContextPath() + "/schools");
    }
}