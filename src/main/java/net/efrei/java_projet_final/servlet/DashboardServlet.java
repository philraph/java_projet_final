package net.efrei.java_projet_final.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.efrei.java_projet_final.entities.UtilisateurEntity;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private final UtilisateurService _userService = new UtilisateurService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard.jsp");

        UtilisateurEntity user = (UtilisateurEntity) session.getAttribute("user");
        req.setAttribute("username", user.getUsername());

        dispatcher.forward(req, resp);
    }
}
