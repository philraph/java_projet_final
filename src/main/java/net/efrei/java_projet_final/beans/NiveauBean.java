package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.Niveau;

import java.util.List;

@Stateless
public class NiveauBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

    public void create(Niveau niveau) {
        em.persist(niveau);
    }

    public void update(Niveau niveau) {
        em.merge(niveau);
    }

    public void delete(Niveau niveau) {
        if (em.contains(niveau)) {
            em.remove(niveau);
        } else {
            em.remove(em.merge(niveau));
        }
    }

    public Niveau findByNiveau(String niveau) {
        List<Niveau> result = em.createNamedQuery("Niveau.findByNiveau", Niveau.class).setParameter("niveau", niveau).getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public List<Niveau> findAll() {
        return em.createNamedQuery("Niveau.findAll", Niveau.class).getResultList();
    }

}
