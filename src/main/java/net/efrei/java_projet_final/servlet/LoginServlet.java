package net.efrei.java_projet_final.servlet;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UtilisateurService _userService = new UtilisateurService();

    boolean login(String username, String mdp){

        var user = _userService.findByUsername(username);

        // Si l'utilisateur existe
        if ( user != null ) {
            BCrypt.Result result = BCrypt.verifyer().verify(mdp.toCharArray(), user.getPassword());

            return result.verified;
        }
        else {
            // L'utilisateur n'existe pas
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }
}
