package net.efrei.java_projet_final.servlet;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.entities.UtilisateurEntity;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;

@WebServlet("/test-persistence")
public class TestPersistenceServlet extends HttpServlet {

    @Inject
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UtilisateurEntity user = new UtilisateurEntity();
        user.setUsername("test");
        user.setPassword("test");
        user.setIsAdmin(false);
        user.setIsValid(true);

        utilisateurService.register(user);

        resp.getWriter().println("Persistence works!");

    }
}
