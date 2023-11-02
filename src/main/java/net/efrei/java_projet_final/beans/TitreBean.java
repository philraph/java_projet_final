package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.Titre;

import java.util.List;

@Stateless
public class TitreBean {

    @PersistenceContext()
    private EntityManager em;

    public void create(Titre titre) {
        em.persist(titre);
    }

    public void update(Titre titre) {
        em.merge(titre);
    }

    public void delete(Titre titre) {
        if (em.contains(titre)) {
            em.remove(titre);
        } else {
            em.remove(em.merge(titre));
        }
    }

    public Titre findByNomTitre(String nomTitre) {
        List<Titre> results = em.createNamedQuery("Titre.findByNomTitre", Titre.class)
                .setParameter("nomTitre", nomTitre)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public List<Titre> findAll() {
        return em.createNamedQuery("Titre.findAll", Titre.class).getResultList();
    }
}

