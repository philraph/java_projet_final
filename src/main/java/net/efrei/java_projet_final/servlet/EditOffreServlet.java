package net.efrei.java_projet_final.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.entities.Offre;
import net.efrei.java_projet_final.services.OffreService;

import java.io.IOException;

@WebServlet("/edit-offer/*")
public class EditOffreServlet extends HttpServlet {
    @Inject
    private OffreService offreService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the Offre to be edited from the request parameter
        String idParam = request.getParameter("id");

        if (idParam != null) {
            // Parse the ID to an integer
            try {
                int id = Integer.parseInt(idParam);
                // Find the Offre entity by its ID
                Offre offre = offreService.findById(id);

                if (offre != null) {
                    // Forward the request to the edit-offre.jsp file with the Offre entity
                    request.setAttribute("offre", offre);
                    request.getRequestDispatcher("/edit-offre.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle invalid ID parameter here
            }
        }

        // Redirect to an error page if the Offre was not found or there was an error
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from the request
        String idParam = request.getParameter("id");
        String intitule = request.getParameter("intitule");
        String exigences = request.getParameter("exigences");
        String remarques = request.getParameter("remarques");

        if (idParam != null) {
            // Parse the ID to an integer
            try {
                int id = Integer.parseInt(idParam);
                // Find the Offre entity by its ID
                Offre offre = offreService.findById(id);

                if (offre != null) {
                    // Update the Offre entity with the new values
                    offre.setIntitule(intitule);
                    offre.setExigences(exigences);
                    offre.setRemarques(remarques);
                    // Save the updated Offre entity
                    offreService.update(offre);

                    // Redirect to a success page
                    response.sendRedirect(request.getContextPath() + "/success.jsp");
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle invalid ID parameter here
            }
        }

        // Redirect to an error page if the Offre was not found or there was an error
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }
}
