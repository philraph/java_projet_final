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
            resp.sendRedirect("schools");
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            resp.sendRedirect("schools");
            return;
        }

        int ecoleId;
        try {
            ecoleId = Integer.parseInt(splits[1]);
        } catch (NumberFormatException e) {
            resp.sendRedirect("schools");
            return;
        }

        Ecole ecole = ecoleService.findById(ecoleId);
        if (ecole == null) {
            resp.sendRedirect("schools");
            return;
        }

        req.setAttribute("school", ecole);
        req.getRequestDispatcher("/WEB-INF/pages/schoolDetails.jsp").forward(req, resp);
    }
}
