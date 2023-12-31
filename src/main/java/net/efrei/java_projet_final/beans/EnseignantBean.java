package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.Enseignant;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class EnseignantBean extends AbstractBean<Enseignant> {

    public List<Enseignant> findAll() {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findAll", Enseignant.class);
        return query.getResultList();
    }

    public Enseignant findById(Integer id) {
        return em.find(Enseignant.class, id);
    }

    public List<Enseignant> findByNom(String nom) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByNom", Enseignant.class);
        query.setParameter("nom", nom);
        return query.getResultList();
    }

    public List<Enseignant> findByPrenom(String prenom) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByPrenom", Enseignant.class);
        query.setParameter("prenom", prenom);
        return query.getResultList();
    }

    public Enseignant findByMail(String mail) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByMail", Enseignant.class);
        query.setParameter("mail", mail);
        return query.getResultStream().findFirst().orElse(null);
    }

    public Enseignant findByTelephone(String telephone) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByTelephone", Enseignant.class);
        query.setParameter("telephone", telephone);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<Enseignant> findByCentreInterets(String centreInterets) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByCentreInterets", Enseignant.class);
        query.setParameter("centreInterets", centreInterets);
        return query.getResultList();
    }

    public List<Enseignant> findBySites(String sites) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findBySites", Enseignant.class);
        query.setParameter("sites", sites);
        return query.getResultList();
    }

    public List<Enseignant> findByTypeContrat(String typeContrat) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByTypeContrat", Enseignant.class);
        query.setParameter("typeContrat", typeContrat);
        return query.getResultList();
    }

    public List<Enseignant> findByExtra(String extra) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByExtra", Enseignant.class);
        query.setParameter("extra", extra);
        return query.getResultList();
    }

    public Enseignant findByUsername(String username) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByUsername", Enseignant.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst().orElse(null);
    }

    public Enseignant findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        TypedQuery<Enseignant> query = em.createNamedQuery("Enseignant.findByUsernameAndStatus", Enseignant.class);
        query.setParameter("username", username);
        query.setParameter("isAdmin", isAdmin);
        query.setParameter("isValid", isValid);
        return query.getResultStream().findFirst().orElse(null);
    }

}
