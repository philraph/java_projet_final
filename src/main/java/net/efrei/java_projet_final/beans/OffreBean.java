package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.OffreEntity;

import java.util.List;

@Stateless
public class OffreBean {

    @PersistenceContext()
    private EntityManager em;

    public void create(OffreEntity offre) {
        em.persist(offre);
    }

    public void update(OffreEntity offre) {
        em.merge(offre);
    }

    public void delete(OffreEntity offre) {
        if (em.contains(offre)) {
            em.remove(offre);
        } else {
            em.remove(em.merge(offre));
        }
    }

    public List<OffreEntity> findAll() {
        TypedQuery<OffreEntity> query = em.createNamedQuery("OffreEntity.findAll", OffreEntity.class);
        return query.getResultList();
    }

    public List<OffreEntity> findByExigences(String exigences) {
        TypedQuery<OffreEntity> query = em.createNamedQuery("OffreEntity.findByExigences", OffreEntity.class);
        query.setParameter("exigences", exigences);
        return query.getResultList();
    }

    public List<OffreEntity> findByRemarques(String remarques) {
        TypedQuery<OffreEntity> query = em.createNamedQuery("OffreEntity.findByRemarques", OffreEntity.class);
        query.setParameter("remarques", remarques);
        return query.getResultList();
    }

    public OffreEntity findById(Integer id) {
        return em.find(OffreEntity.class, id);
    }

}