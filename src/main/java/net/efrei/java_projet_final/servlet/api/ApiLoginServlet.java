package net.efrei.java_projet_final.servlet.api;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import net.efrei.java_projet_final.services.AuthenticationService;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/login")
public class ApiLoginServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    private AuthenticationService _authService;

    @Inject
    private UtilisateurService _userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map<String, String> responseMap = new HashMap<>();

        if (_authService.loginUtilisateur(username, password)) {
            responseMap.put("status", "success");
            responseMap.put("message", "success");

            HttpSession session = req.getSession();
            session.setAttribute("user", _userService.findByUsername(username));
        } else {
            responseMap.put("status", "error");
            responseMap.put("message", "Invalid credentials!");
        }

        String jsonResponse = objectMapper.writeValueAsString(responseMap);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonResponse);
    }
}
