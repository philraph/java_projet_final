package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.Titre;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class TitreBean extends AbstractBean {

    public void create(Titre titre) {
        TransactionalOperation.execute(em, () -> em.persist(titre));
    }

    public void update(Titre titre) {
        TransactionalOperation.execute(em, () -> em.merge(titre));
    }

    public void delete(Titre titre) {
        TransactionalOperation.execute(em, () -> {
            if (em.contains(titre)) {
                em.remove(titre);
            } else {
                em.remove(em.merge(titre));
            }
        });
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

