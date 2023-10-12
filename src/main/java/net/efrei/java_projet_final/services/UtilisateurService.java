package net.efrei.java_projet_final.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.beans.UtilisateurBean;
import net.efrei.java_projet_final.entities.UtilisateurEntity;

import java.util.List;

@Stateless
public class UtilisateurService {

    @EJB
    private UtilisateurBean utilisateurBean;

    public void register(UtilisateurEntity utilisateur) {
        utilisateurBean.create(utilisateur);
    }

    public void update(UtilisateurEntity utilisateur) {
        utilisateurBean.update(utilisateur);
    }

    public void delete(UtilisateurEntity utilisateur) {
        utilisateurBean.delete(utilisateur);
    }

    public UtilisateurEntity findById(Object id) {
        return utilisateurBean.findById(id);
    }

    public List<UtilisateurEntity> getAllUsers() {
        return utilisateurBean.findAll();
    }

    public UtilisateurEntity findByUsername(String username) {
        return utilisateurBean.findByUsername(username);
    }

    public List<UtilisateurEntity> getAdmins(Boolean isAdmin) {
        return utilisateurBean.findByIsAdmin(isAdmin);
    }

    public List<UtilisateurEntity> getValidUsers(Boolean isValid) {
        return utilisateurBean.findByIsValid(isValid);
    }

    public List<UtilisateurEntity> getUsersByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return utilisateurBean.findByUsernameAndStatus(username, isAdmin, isValid);
    }
}