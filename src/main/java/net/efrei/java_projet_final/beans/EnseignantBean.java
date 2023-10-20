package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.EnseignantEntity;

import java.util.List;

@Stateless
public class EnseignantBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("projet").createEntityManager();

    public void create(EnseignantEntity enseignant) {
        em.persist(enseignant);
    }

    public void update(EnseignantEntity enseignant) {
        em.merge(enseignant);
    }

    public void delete(EnseignantEntity enseignant) {
        if (em.contains(enseignant)) {
            em.remove(enseignant);
        } else {
            em.remove(em.merge(enseignant));
        }
    }

    public List<EnseignantEntity> findAll() {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findAll", EnseignantEntity.class);
        return query.getResultList();
    }

    public EnseignantEntity findById(Integer id) {
        return em.find(EnseignantEntity.class, id);
    }

    public List<EnseignantEntity> findByNom(String nom) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByNom", EnseignantEntity.class);
        query.setParameter("nom", nom);
        return query.getResultList();
    }

    public List<EnseignantEntity> findByPrenom(String prenom) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByPrenom", EnseignantEntity.class);
        query.setParameter("prenom", prenom);
        return query.getResultList();
    }

    public EnseignantEntity findByMail(String mail) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByMail", EnseignantEntity.class);
        query.setParameter("mail", mail);
        return query.getSingleResult();
    }

    public EnseignantEntity findByTelephone(String telephone) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByTelephone", EnseignantEntity.class);
        query.setParameter("telephone", telephone);
        return query.getSingleResult();
    }

    public List<EnseignantEntity> findByCentreInterets(String centreInterets) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByCentreInterets", EnseignantEntity.class);
        query.setParameter("centreInterets", centreInterets);
        return query.getResultList();
    }

    public List<EnseignantEntity> findBySites(String sites) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findBySites", EnseignantEntity.class);
        query.setParameter("sites", sites);
        return query.getResultList();
    }

    public List<EnseignantEntity> findByTypeContrat(String typeContrat) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByTypeContrat", EnseignantEntity.class);
        query.setParameter("typeContrat", typeContrat);
        return query.getResultList();
    }

    public List<EnseignantEntity> findByExtra(String extra) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByExtra", EnseignantEntity.class);
        query.setParameter("extra", extra);
        return query.getResultList();
    }

    public EnseignantEntity findByUsername(String username) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByUsername", EnseignantEntity.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    public EnseignantEntity findByUsernameAndStatus(String username, Boolean isAdmin, Boolean isValid) {
        TypedQuery<EnseignantEntity> query = em.createNamedQuery("EnseignantEntity.findByUsernameAndStatus", EnseignantEntity.class);
        query.setParameter("username", username);
        query.setParameter("isAdmin", isAdmin);
        query.setParameter("isValid", isValid);
        return query.getSingleResult();
    }

}
