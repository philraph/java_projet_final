package net.efrei.java_projet_final.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.inject.Inject;

public class AuthentificationService {

    @Inject
    private UtilisateurService _userService;

    public boolean login(String username, String mdp){

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