package net.efrei.java_projet_final.servlet;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.efrei.java_projet_final.services.UtilisateurService;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UtilisateurService _userService = new UtilisateurService();

    boolean register(String username, String mdp){

        var user = _userService.findByUsername(username);

        if(user != null){
            // Le nom d'utilisateur existe déjà
            return false;
        }
        else {
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, mdp.toCharArray());
            user.setPassword(bcryptHashString);
            user.setUsername(username);

            _userService.register(user);
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
        dispatcher.forward(req, resp);
    }
}
