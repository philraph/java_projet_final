package net.efrei.java_projet_final.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import net.efrei.java_projet_final.security.Group;
import net.efrei.java_projet_final.security.Protected;

import java.io.IOException;

@WebServlet("/auth/login")
@Protected(Group.GUEST)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/auth/login.jsp");
        dispatcher.forward(req, resp);
    }
}
