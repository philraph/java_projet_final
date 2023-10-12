package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.NiveauEntity;

import java.util.List;

@Stateless
public class NiveauBean {

    @PersistenceContext()
    private EntityManager em;

    public void create(NiveauEntity niveau) {
        em.persist(niveau);
    }

    public void update(NiveauEntity niveau) {
        em.merge(niveau);
    }

    public void delete(NiveauEntity niveau) {
        if (em.contains(niveau)) {
            em.remove(niveau);
        } else {
            em.remove(em.merge(niveau));
        }
    }

    public NiveauEntity findByNiveau(String niveau) {
        List<NiveauEntity> result = em.createNamedQuery("NiveauEntity.findByNiveau", NiveauEntity.class).setParameter("niveau", niveau).getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public List<NiveauEntity> findAll() {
        return em.createNamedQuery("NiveauEntity.findAll", NiveauEntity.class).getResultList();
    }

}
