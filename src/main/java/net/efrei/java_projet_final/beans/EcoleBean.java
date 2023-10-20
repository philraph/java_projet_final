package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.EcoleEntity;

import java.util.List;

@Stateless
public class EcoleBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("projet").createEntityManager();

    public void create(EcoleEntity ecole) {
        em.persist(ecole);
    }

    public void update(EcoleEntity ecole) {
        em.merge(ecole);
    }

    public void delete(EcoleEntity ecole) {
        if (em.contains(ecole)) {
            em.remove(ecole);
        } else {
            em.remove(em.merge(ecole));
        }
    }

    public List<EcoleEntity> findAll() {
        TypedQuery<EcoleEntity> query = em.createNamedQuery("EcoleEntity.findAll", EcoleEntity.class);
        return query.getResultList();
    }

    public EcoleEntity findById(Integer id) {
        return em.find(EcoleEntity.class, id);
    }

    public EcoleEntity findByRaisonSociale(String raisonSociale) {
        TypedQuery<EcoleEntity> query = em.createNamedQuery("EcoleEntity.findByRaisonSociale", EcoleEntity.class);
        query.setParameter("raisonSociale", raisonSociale);
        return query.getSingleResult();
    }

    public EcoleEntity findByUsername(String username) {
        TypedQuery<EcoleEntity> query = em.createNamedQuery("EcoleEntity.findByUsername", EcoleEntity.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
