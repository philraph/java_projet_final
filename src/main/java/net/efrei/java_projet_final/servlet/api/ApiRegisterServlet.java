package net.efrei.java_projet_final.servlet.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.efrei.java_projet_final.services.AuthentificationService;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/register")
public class ApiRegisterServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    private AuthentificationService _authService;

    @Inject
    private UtilisateurService _userService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Champs commun à tou t types d'utilisateur
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String accountType = req.getParameter("accountType");
        String terms = req.getParameter("terms");
        String notification = req.getParameter("notification");

        System.out.println("terms : " + terms +"\n");
        System.out.println("notification : " + notification +"\n");

        Map<String, String> responseMap = new HashMap<>();

        boolean isSuccess = false;

        // Create a new user
        if(accountType.equals("ecole")){
            String raisonSocial = req.getParameter("raison");

            isSuccess = _authService.registerEcole(username, password, raisonSocial);
        }
        else if(accountType == "enseignant") {
            String name = req.getParameter("name");
            String prenom = req.getParameter("prenom");
            String email = req.getParameter("email");
            String telephone = req.getParameter("telephone");
            String centreInteret = req.getParameter("centreInteret");
            String site = req.getParameter("site");
            String contrat = req.getParameter("contrat");
            String extra = req.getParameter("extra");

            isSuccess = _authService.registerEnseignant(username,
                                                        password,
                                                        name,
                                                        prenom,
                                                        email,
                                                        telephone,
                                                        centreInteret,
                                                        site,
                                                        contrat,
                                                        extra);
        }

        if (isSuccess) {
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

