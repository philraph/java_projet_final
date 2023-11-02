package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.Ecole;

import java.util.List;

@Stateless
public class EcoleBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();

    public void create(Ecole ecole) {
        em.persist(ecole);
    }

    public void update(Ecole ecole) {
        em.merge(ecole);
    }

    public void delete(Ecole ecole) {
        if (em.contains(ecole)) {
            em.remove(ecole);
        } else {
            em.remove(em.merge(ecole));
        }
    }

    public List<Ecole> findAll() {
        TypedQuery<Ecole> query = em.createNamedQuery("Ecole.findAll", Ecole.class);
        return query.getResultList();
    }

    public Ecole findById(Integer id) {
        return em.find(Ecole.class, id);
    }

    public Ecole findByRaisonSociale(String raisonSociale) {
        TypedQuery<Ecole> query = em.createNamedQuery("Ecole.findByRaisonSociale", Ecole.class);
        query.setParameter("raisonSociale", raisonSociale);
        return query.getSingleResult();
    }

    public Ecole findByUsername(String username) {
        TypedQuery<Ecole> query = em.createNamedQuery("Ecole.findByUsername", Ecole.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
