package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.TitreEntity;

import java.util.List;

@Stateless
public class TitreBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("projet").createEntityManager();

    public void create(TitreEntity titre) {
        em.persist(titre);
    }

    public void update(TitreEntity titre) {
        em.merge(titre);
    }

    public void delete(TitreEntity titre) {
        if (em.contains(titre)) {
            em.remove(titre);
        } else {
            em.remove(em.merge(titre));
        }
    }

    public TitreEntity findByNomTitre(String nomTitre) {
        List<TitreEntity> results = em.createNamedQuery("TitreEntity.findByNomTitre", TitreEntity.class)
                .setParameter("nomTitre", nomTitre)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public List<TitreEntity> findAll() {
        return em.createNamedQuery("TitreEntity.findAll", TitreEntity.class).getResultList();
    }
}

