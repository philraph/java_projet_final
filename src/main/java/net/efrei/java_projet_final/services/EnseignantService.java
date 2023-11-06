package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;
import net.efrei.java_projet_final.beans.EnseignantBean;
import net.efrei.java_projet_final.entities.Enseignant;

import java.util.List;

@ApplicationScoped
public class EnseignantService {

    @EJB
    private EnseignantBean enseignantBean;

    public void create(Enseignant enseignant) {
        enseignantBean.create(enseignant);
    }

    public void update(Enseignant updatedEnseignant) {
        enseignantBean.update(updatedEnseignant);
    }

    public void delete(Enseignant enseignant) {
        enseignantBean.delete(enseignant);
    }

    public List<Enseignant> findAll() {
        return enseignantBean.findAll();
    }

    public Enseignant findById(Integer id) {
        return enseignantBean.findById(id);
    }

    public List<Enseignant> findByNom(String nom) {
        return enseignantBean.findByNom(nom);
    }

    public List<Enseignant> findByPrenom(String prenom) {
        return enseignantBean.findByPrenom(prenom);
    }

    public Enseignant findByMail(String mail) {
        return enseignantBean.findByMail(mail);
    }

    public Enseignant findByTelephone(String telephone) {
        return enseignantBean.findByTelephone(telephone);
    }

    public List<Enseignant> findByCentreInterets(String centreInterets) {
        return enseignantBean.findByCentreInterets(centreInterets);
    }

    public List<Enseignant> findBySites(String sites) {
        return enseignantBean.findBySites(sites);
    }

    public List<Enseignant> findByTypeContrat(String typeContrat) {
        return enseignantBean.findByTypeContrat(typeContrat);
    }

    public List<Enseignant> findByExtra(String extra) {
        return enseignantBean.findByExtra(extra);
    }

    public Enseignant findByUsername(String username) {
        return enseignantBean.findByUsername(username);
    }

    public Enseignant findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return enseignantBean.findByUsernameAndStatus(username, isAdmin, isValid);
    }
}