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
import java.util.List;

@WebServlet("/schools")
public class SchoolServlet extends HttpServlet {

    @Inject
    private EcoleService ecoleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ecole> ecoles = ecoleService.findAll();
        req.setAttribute("schools", ecoles);

        req.getRequestDispatcher("/WEB-INF/pages/schools.jsp").forward(req, resp);
    }

}
