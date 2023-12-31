package net.efrei.java_projet_final.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.security.Group;
import net.efrei.java_projet_final.security.Protected;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/adminConfirmAccount")
//@Protected(Group.ADMIN)
public class adminConfirmAccount extends HttpServlet {

    @Inject
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Utilisateur> users = utilisateurService.findByIsValid(false);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/pages/adminConfirmAccount.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        Utilisateur user = utilisateurService.findById(userId);
        user.setIsValid(true);
        utilisateurService.update(user);
        resp.sendRedirect("adminConfirmAccount");
//        req.getRequestDispatcher("/WEB-INF/pages/adminConfirmAccount.jsp").forward(req, resp);
    }


}
