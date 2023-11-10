package net.efrei.java_projet_final.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Enseignant;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.security.Group;
import net.efrei.java_projet_final.security.Protected;
import net.efrei.java_projet_final.services.*;

import java.io.IOException;

@WebServlet("/dashboard")
@Protected(Group.VALID_USER)
public class DashboardServlet extends HttpServlet {

    @Inject
    private UtilisateurService _userService;

    @Inject
    private EcoleService _ecoleService;

    @Inject
    private EnseignantService _enseignantService;

    @Inject
    private OffreService _offreService;

    @Inject
    private CandidateService _candidateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur user = (Utilisateur) req.getAttribute("user");
        if(_userService.hasGroup(user, Group.ADMIN)) {
            req.setAttribute("users", _userService.findAll());
            req.setAttribute("ecoles", _ecoleService.findAll());
            req.setAttribute("enseignants", _enseignantService.findAll());
            req.setAttribute("candidates", _candidateService.findAll());
        }

        if(_userService.hasGroup(user, Group.ECOLE)) {
            Ecole ecole = _ecoleService.findByUsername(user.getUsername());
            req.setAttribute("ecole", ecole);
            req.setAttribute("candidatures", _candidateService.findByEcole(ecole));
        }

        if(_userService.hasGroup(user, Group.ENSEIGNANT)) {
            Enseignant enseignant = _enseignantService.findByUsername(user.getUsername());
            req.setAttribute("enseignant", enseignant);
            req.setAttribute("candidatures", _candidateService.findByEnseignant(enseignant));
            req.setAttribute("offres", _offreService.findAll());
        }

        req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(req, resp);
    }
}
