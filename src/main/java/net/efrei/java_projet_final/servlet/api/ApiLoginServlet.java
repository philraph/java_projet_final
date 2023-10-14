package net.efrei.java_projet_final.servlet.api;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import net.efrei.java_projet_final.services.AuthentificationService;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiLoginServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    public AuthentificationService _authService;

    @Inject
    public UtilisateurService _userService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //String password = req.getParameter("ecole");

        Map<String, String> responseMap = new HashMap<>();

        if (_authService.register(username, password)) {
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