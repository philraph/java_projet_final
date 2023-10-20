package net.efrei.java_projet_final.servlet.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.efrei.java_projet_final.services.AuthentificationService;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/register")
public class ApiRegisterServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final AuthentificationService _authService = new AuthentificationService();

    private final UtilisateurService _userService = new UtilisateurService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String accountType = req.getParameter("accountType");
        String terms = req.getParameter("terms");
        String notification = req.getParameter("notification");

        Map<String, String> responseMap = new HashMap<>();


        // Create a new user
        if (_authService.register(username, password)) {
            responseMap.put("status", "success");
            responseMap.put("message", "registration");

            HttpSession session = req.getSession();
            session.setAttribute("user", _userService.findByUsername(username));
        } else {
            responseMap.put("status", "error");
            responseMap.put("message", "registration");
        }

        String jsonResponse = objectMapper.writeValueAsString(responseMap);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonResponse);
    }
}

