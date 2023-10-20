package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.UtilisateurEntity;

import java.util.List;

@Stateless
public class UtilisateurBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("projet").createEntityManager();

    public void create(UtilisateurEntity utilisateur) {
        em.persist(utilisateur);
    }

    public void update(UtilisateurEntity utilisateur) {
        em.merge(utilisateur);
    }

    public void delete(UtilisateurEntity utilisateur) {
        if (em.contains(utilisateur)) {
            em.remove(utilisateur);
        } else {
            em.remove(em.merge(utilisateur));
        }
    }

    public UtilisateurEntity findById(Object id) {
        return em.find(UtilisateurEntity.class, id);
    }

    public List<UtilisateurEntity> findAll() {
        return em.createNamedQuery("UtilisateurEntity.findAll", UtilisateurEntity.class).getResultList();
    }

    public UtilisateurEntity findByUsername(String username) {
        return em.createNamedQuery("UtilisateurEntity.findByUsername", UtilisateurEntity.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public List<UtilisateurEntity> findByIsAdmin(Boolean isAdmin) {
        return em.createNamedQuery("UtilisateurEntity.findByIsAdmin", UtilisateurEntity.class)
                .setParameter("isAdmin", isAdmin)
                .getResultList();
    }

    public List<UtilisateurEntity> findByIsValid(Boolean isValid) {
        return em.createNamedQuery("UtilisateurEntity.findByIsValid", UtilisateurEntity.class)
                .setParameter("isValid", isValid)
                .getResultList();
    }

    public List<UtilisateurEntity> findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        return em.createNamedQuery("UtilisateurEntity.findByUsernameAndStatus", UtilisateurEntity.class)
                .setParameter("username", username)
                .setParameter("isAdmin", isAdmin)
                .setParameter("isValid", isValid)
                .getResultList();
    }
}
