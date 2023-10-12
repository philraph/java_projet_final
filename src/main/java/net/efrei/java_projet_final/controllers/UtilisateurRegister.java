package net.efrei.java_projet_final.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import net.efrei.java_projet_final.services.UtilisateurService;

public class UtilisateurRegister {

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
}


