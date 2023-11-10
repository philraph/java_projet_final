package net.efrei.java_projet_final.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Typed;
import jakarta.inject.Singleton;
import net.efrei.java_projet_final.beans.UtilisateurBean;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.security.Group;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class UtilisateurService {

    @EJB
    private UtilisateurBean utilisateurBean;

    public void register(Utilisateur utilisateur) {
        utilisateurBean.create(utilisateur);
    }

    public void update(Utilisateur utilisateur) {
        utilisateurBean.update(utilisateur);
    }

    public void delete(Utilisateur utilisateur) {
        utilisateurBean.delete(utilisateur);
    }

    public Utilisateur findById(Object id) {
        return utilisateurBean.findById(id);
    }

    public List<Utilisateur> findAll() {
        return utilisateurBean.findAll();
    }

    public Utilisateur findByUsername(String username) {
        return utilisateurBean.findByUsername(username);
    }

    public List<Utilisateur> findByIsAdmin(Boolean isAdmin) {
        return utilisateurBean.findByIsAdmin(isAdmin);
    }

    public List<Utilisateur> findByIsValid(Boolean isValid) {
        return utilisateurBean.findByIsValid(isValid);
    }

    public List<Utilisateur> findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return utilisateurBean.findByUsernameAndStatus(username, isAdmin, isValid);
    }

    public boolean hasGroup(Utilisateur utilisateur, Group group) {
        return utilisateurBean.computeGroups(utilisateur).contains(group);
    }

    public boolean hasGroups(Utilisateur utilisateur, Group[] groups) {
        return Arrays.stream(groups).allMatch(utilisateurBean.computeGroups(utilisateur)::contains);
    }
}