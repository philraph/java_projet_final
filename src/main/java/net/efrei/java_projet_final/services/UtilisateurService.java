package net.efrei.java_projet_final.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Singleton;
import net.efrei.java_projet_final.beans.UtilisateurBean;
import net.efrei.java_projet_final.entities.UtilisateurEntity;

import java.util.List;

@Singleton
@Default
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

    public List<UtilisateurEntity> findAll() {
        return utilisateurBean.findAll();
    }

    public UtilisateurEntity findByUsername(String username) {
        return utilisateurBean.findByUsername(username);
    }

    public List<UtilisateurEntity> findByIsAdmin(Boolean isAdmin) {
        return utilisateurBean.findByIsAdmin(isAdmin);
    }

    public List<UtilisateurEntity> findByIsValid(Boolean isValid) {
        return utilisateurBean.findByIsValid(isValid);
    }

    public List<UtilisateurEntity> findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return utilisateurBean.findByUsernameAndStatus(username, isAdmin, isValid);
    }
}