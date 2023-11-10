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
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.security.Group;
import net.efrei.java_projet_final.security.Protected;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;

@WebServlet("/dashboard")
@Protected(Group.VALID_USER)
public class DashboardServlet extends HttpServlet {

    @Inject
    private UtilisateurService _userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp");

        Utilisateur user = (Utilisateur) session.getAttribute("user");
        req.setAttribute("username", user.getUsername());

        dispatcher.forward(req, resp);
    }
}
