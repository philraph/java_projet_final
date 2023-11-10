package net.efrei.java_projet_final.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.services.UtilisateurService;
import java.io.IOException;

import java.util.List;


@WebServlet("/users")
public class UtilisateurServlet extends HttpServlet {

    @Inject
    private UtilisateurService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Utilisateur> users = userService.findByIsValid(true);

        // Set the 'users' attribute in the request
        req.setAttribute("validUsers", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/utilisateurValides.jsp");
        dispatcher.forward(req, resp);
    }
}
