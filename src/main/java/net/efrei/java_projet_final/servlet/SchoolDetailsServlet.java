package net.efrei.java_projet_final.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.services.EcoleService;

import java.io.IOException;

@WebServlet("/schools/*")
public class SchoolDetailsServlet extends HttpServlet {

    @Inject
    private EcoleService ecoleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // Gérer le cas où aucun ID d'école n'est fourni, rediriger vers la liste des écoles par exemple
            resp.sendRedirect("schools");
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            // Gérer l'erreur si le chemin est incorrect
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        int ecoleId;
        try {
            ecoleId = Integer.parseInt(splits[1]);
        } catch (NumberFormatException e) {
            // Gérer l'erreur si l'ID n'est pas un nombre
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Ecole ecole = ecoleService.findById(ecoleId);
        if (ecole == null) {
            // Gérer l'erreur si l'école n'est pas trouvée
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        req.setAttribute("school", ecole);
        req.getRequestDispatcher("/WEB-INF/pages/schoolDetails.jsp").forward(req, resp);
    }
}
