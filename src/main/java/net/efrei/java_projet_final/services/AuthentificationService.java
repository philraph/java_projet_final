package net.efrei.java_projet_final.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.efrei.java_projet_final.entities.EcoleEntity;
import net.efrei.java_projet_final.entities.EnseignantEntity;

@ApplicationScoped
public class AuthentificationService {

    @Inject
    private UtilisateurService _userService;

    @Inject
    private EcoleService _ecoleService;

    @Inject
    private EnseignantService _enseignantService;

    public boolean loginUtilisateur(String username, String mdp){

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

    public boolean loginEcole(String username,
                              String mdp,
                              String raisonSocial){

        var shcool = _ecoleService.findByUsername(username);

        // Si l'école existe
        if ( shcool != null ) {
            BCrypt.Result result = BCrypt.verifyer().verify(mdp.toCharArray(), shcool.getUtilisateur().getPassword());

            return result.verified;
        }
        else {
            // L'utilisateur n'existe pas
            return false;
        }
    }

    public boolean registerEnseignant(String username,
                                      String mdp,
                                      String name,
                                      String prenom,
                                      String email,
                                      String telephone,
                                      String centreInteret,
                                      String site,
                                      String contrat,
                                      String extra){

        var user = _userService.findByUsername(username);

        if(user != null){
            // Le nom d'utilisateur existe déjà
            return false;
        }
        else {
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, mdp.toCharArray());

            // Crée un nouveau utilisteur
            user.setPassword(bcryptHashString);
            user.setUsername(username);
            user.setIsValid(false);

            // Crée un nouvel enseignant
            EnseignantEntity newEnseignant = new EnseignantEntity();
            newEnseignant.setUtilisateur(user);
            newEnseignant.setMail(email);
            newEnseignant.setExtra(extra);
            newEnseignant.setNom(name);
            newEnseignant.setPrenom(prenom);
            newEnseignant.setSites(site);
            newEnseignant.setTelephone(telephone);
            newEnseignant.setCentreInterets(centreInteret);
            newEnseignant.setTypeContrat(contrat);

            _userService.register(user);
            _enseignantService.create(newEnseignant);

            System.out.println(newEnseignant.toString());

            return false;
        }
    }

    public boolean registerEcole(String username, String mdp, String raisonSocial){

        var user = _userService.findByUsername(username);

        if(user != null){
            // Le nom d'utilisateur existe déjà
            return false;
        }
        else {
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, mdp.toCharArray());

            // Crée un nouveau utilisteur
            user.setPassword(bcryptHashString);
            user.setUsername(username);
            user.setIsValid(false);

            // Crée un nouvel enseignant
            EcoleEntity newEcole = new EcoleEntity();
            newEcole.setUtilisateur(user);
            newEcole.setRaisonSociale(raisonSocial);

            _userService.register(user);
            _ecoleService.create(newEcole);

            System.out.println(newEcole.toString());
            return false;
        }
    }
}
