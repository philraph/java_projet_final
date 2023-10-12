package net.efrei.java_projet_final.controllers;


import at.favre.lib.crypto.bcrypt.BCrypt;
import net.efrei.java_projet_final.services.UtilisateurService;

public class UtilisateurLogin {

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
}
