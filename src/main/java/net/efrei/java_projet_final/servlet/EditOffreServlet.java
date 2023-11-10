package net.efrei.java_projet_final.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Offre;
import net.efrei.java_projet_final.services.OffreService;

import java.io.IOException;

@WebServlet("/edit/offres/*")
public class EditOffreServlet extends HttpServlet {
    @Inject
    private OffreService offreService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendRedirect("dashboard");
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            resp.sendRedirect("dashboard");
            return;
        }

        int offerId;
        try {
            offerId = Integer.parseInt(splits[1]);
        } catch (NumberFormatException e) {
            resp.sendRedirect("dashboard");
            return;
        }

        Offre offre = offreService.findById(offerId);
        if (offre == null) {
            resp.sendRedirect("schools");
            return;
        }

        req.setAttribute("offre", offre);
        req.getRequestDispatcher("/WEB-INF/pages/editOffre.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve form data from the request
        String intitule = req.getParameter("intitule");
        String exigences = req.getParameter("exigences");
        String remarques = req.getParameter("remarques");

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendRedirect("dashboard");
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            resp.sendRedirect("dashboard");
            return;
        }

        int offerId;
        try {
            offerId = Integer.parseInt(splits[1]);
        } catch (NumberFormatException e) {
            resp.sendRedirect("dashboard");
            return;
        }

        Offre offre = offreService.findById(offerId);
        if (offre == null) {
            resp.sendRedirect("schools");
            return;
        }

        // Update the Offre entity with the new values
        offre.setIntitule(intitule);
        offre.setExigences(exigences);
        offre.setRemarques(remarques);
        // Save the updated Offre entity
        offreService.update(offre);

        // Redirect to a success page
        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}
