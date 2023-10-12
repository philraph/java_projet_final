package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.beans.EnseignantBean;
import net.efrei.java_projet_final.entities.EnseignantEntity;

import java.util.List;

@Stateless
public class EnseignantService {

    @EJB
    private EnseignantBean enseignantBean;

    public List<EnseignantEntity> getAllEnseignants() {
        return enseignantBean.findAll();
    }

    public EnseignantEntity getEnseignantById(Integer id) {
        return enseignantBean.findById(id);
    }

    public void createEnseignant(EnseignantEntity enseignant) {
        enseignantBean.create(enseignant);
    }

    public void updateEnseignant(EnseignantEntity updatedEnseignant) {
        enseignantBean.update(updatedEnseignant);
    }

    public void deleteEnseignant(EnseignantEntity enseignant) {
        enseignantBean.delete(enseignant);
    }

    public List<EnseignantEntity> findByNom(String nom) {
        return enseignantBean.findByNom(nom);
    }

    public List<EnseignantEntity> findByPrenom(String prenom) {
        return enseignantBean.findByPrenom(prenom);
    }

    public List<EnseignantEntity> findByMail(String mail) {
        return enseignantBean.findByMail(mail);
    }

    public List<EnseignantEntity> findByTelephone(String telephone) {
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

    public List<EnseignantEntity> findByUsername(String username) {
        return enseignantBean.findByUsername(username);
    }

    public List<EnseignantEntity> findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return enseignantBean.findByUsernameAndStatus(username, isAdmin, isValid);
    }
}