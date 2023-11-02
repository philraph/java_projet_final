package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.Utilisateur;
import net.efrei.java_projet_final.entities.Utilisateur;

import java.util.List;

@Stateless
public class UtilisateurBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

    public void create(Utilisateur utilisateur) {
        em.persist(utilisateur);
    }

    public void update(Utilisateur utilisateur) {
        em.merge(utilisateur);
    }

    public void delete(Utilisateur utilisateur) {
        if (em.contains(utilisateur)) {
            em.remove(utilisateur);
        } else {
            em.remove(em.merge(utilisateur));
        }
    }

    public Utilisateur findById(Object id) {
        return em.find(Utilisateur.class, id);
    }

    public List<Utilisateur> findAll() {
        return em.createNamedQuery("Utilisateur.findAll", Utilisateur.class).getResultList();
    }

    public Utilisateur findByUsername(String username) {
        return em.createNamedQuery("Utilisateur.findByUsername", Utilisateur.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public List<Utilisateur> findByIsAdmin(Boolean isAdmin) {
        return em.createNamedQuery("Utilisateur.findByIsAdmin", Utilisateur.class)
                .setParameter("isAdmin", isAdmin)
                .getResultList();
    }

    public List<Utilisateur> findByIsValid(Boolean isValid) {
        return em.createNamedQuery("Utilisateur.findByIsValid", Utilisateur.class)
                .setParameter("isValid", isValid)
                .getResultList();
    }

    public List<Utilisateur> findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return em.createNamedQuery("Utilisateur.findByUsernameAndStatus", Utilisateur.class)
                .setParameter("username", username)
                .setParameter("isAdmin", isAdmin)
                .setParameter("isValid", isValid)
                .getResultList();
    }
}
