package net.efrei.java_projet_final.servlet;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/test-persistence")
public class TestPersistenceServlet extends HttpServlet {

    @Inject
    private UtilisateurService utilisateurService;

    @PersistenceContext()
    private EntityManager em;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get current mysql user and database
        em.createNativeQuery("SELECT USER()")
                .getResultList()
                .forEach(resp.getWriter()::println);

        resp.getWriter().println();

        em.createNativeQuery("SELECT DATABASE()")
                .getResultList()
                .forEach(resp.getWriter()::println);

        resp.getWriter().println();

        em.createNativeQuery("SHOW TABLES FROM projet")
                .getResultList()
                .forEach(resp.getWriter()::println);

        Utilisateur user = new Utilisateur();
        user.setUsername("test");
        user.setPassword("test");
        user.setIsAdmin(false);
        user.setIsValid(true);

        utilisateurService.register(user);

        resp.getWriter().println("Persistence works!");

    }
}
