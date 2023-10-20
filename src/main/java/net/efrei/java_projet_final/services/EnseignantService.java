package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Singleton;
import net.efrei.java_projet_final.beans.EnseignantBean;
import net.efrei.java_projet_final.entities.EnseignantEntity;

import java.util.List;

@Stateless
public class EnseignantService {

    @EJB
    private EnseignantBean enseignantBean;

    public void create(EnseignantEntity enseignant) {
        enseignantBean.create(enseignant);
    }

    public void update(EnseignantEntity updatedEnseignant) {
        enseignantBean.update(updatedEnseignant);
    }

    public void delete(EnseignantEntity enseignant) {
        enseignantBean.delete(enseignant);
    }

    public List<EnseignantEntity> findAll() {
        return enseignantBean.findAll();
    }

    public EnseignantEntity findById(Integer id) {
        return enseignantBean.findById(id);
    }

    public List<EnseignantEntity> findByNom(String nom) {
        return enseignantBean.findByNom(nom);
    }

    public List<EnseignantEntity> findByPrenom(String prenom) {
        return enseignantBean.findByPrenom(prenom);
    }

    public EnseignantEntity findByMail(String mail) {
        return enseignantBean.findByMail(mail);
    }

    public EnseignantEntity findByTelephone(String telephone) {
        return enseignantBean.findByTelephone(telephone);
    }

    public List<EnseignantEntity> findByCentreInterets(String centreInterets) {
        return enseignantBean.findByCentreInterets(centreInterets);
    }

    public List<EnseignantEntity> findBySites(String sites) {
        return enseignantBean.findBySites(sites);
    }

    public List<EnseignantEntity> findByTypeContrat(String typeContrat) {
        return enseignantBean.findByTypeContrat(typeContrat);
    }

    public List<EnseignantEntity> findByExtra(String extra) {
        return enseignantBean.findByExtra(extra);
    }

    public EnseignantEntity findByUsername(String username) {
        return enseignantBean.findByUsername(username);
    }

    public EnseignantEntity findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return enseignantBean.findByUsernameAndStatus(username, isAdmin, isValid);
    }
}