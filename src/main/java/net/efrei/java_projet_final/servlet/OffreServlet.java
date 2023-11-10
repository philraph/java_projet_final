package net.efrei.java_projet_final.servlet;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Offre;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.services.EcoleService;
import net.efrei.java_projet_final.services.OffreService;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;

@WebServlet("/offre")
public class OffreServlet extends HttpServlet {

    @Inject
    private OffreService _offreService;

    @Inject
    EcoleService _ecoleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/createOffre.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        // Retrieve form data from the request
        String intitule = request.getParameter("intitule");
        String exigences = request.getParameter("exigences");
        String remarques = request.getParameter("remarques");

        Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

        if(user == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Ecole ecole =  _ecoleService.findByUsername(user.getUsername());

        if(ecole == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

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