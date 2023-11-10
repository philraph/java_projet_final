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

@WebServlet("/schools/edit/*")
public class EditSchoolServlet extends HttpServlet {

    @Inject
    private EcoleService _ecoleService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the Ecole to be edited from the request parameter
        String idParam = request.getParameter("id");

        if (idParam != null) {
            // Parse the ID to an integer
            try {
                int id = Integer.parseInt(idParam);
                // Find the Ecole entity by its ID
                Ecole ecole = _ecoleService.findById(id);

                if (ecole != null) {
                    // Forward the request to the edit-ecole.jsp file with the Ecole entity
                    request.setAttribute("ecole", ecole);
                    request.getRequestDispatcher("/edit-ecole.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle invalid ID parameter here
            }
        }

        // Redirect to a error page if the Ecole was not found or there was an error
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from the request
        String idParam = request.getParameter("id");
        String raisonSociale = request.getParameter("raisonSociale");

        if (idParam != null) {
            // Parse the ID to an integer
            try {
                int id = Integer.parseInt(idParam);
                // Find the Ecole entity by its ID
                Ecole ecole = _ecoleService.findById(id);

                if (ecole != null) {
                    // Update the Ecole entity with the new values
                    ecole.setRaisonSociale(raisonSociale);
                    // Save the updated Ecole entity
                    _ecoleService.update(ecole);

                    // Redirect to a success page
                    response.sendRedirect(request.getContextPath() + "/success.jsp");
                    return;
                }
            } catch (NumberFormatException e) {
                // Handle invalid ID parameter here
            }
        }

        // Redirect to a error page if the Ecole was not found or there was an error
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }
}

