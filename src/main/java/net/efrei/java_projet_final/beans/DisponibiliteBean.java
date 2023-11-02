package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.Disponibilite;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class DisponibiliteBean {

    @PersistenceContext()
    private EntityManager em;

    public void create(Disponibilite disponibilite) {
        em.persist(disponibilite);
    }

    public void update(Disponibilite disponibilite) {
        em.merge(disponibilite);
    }

    public void delete(Disponibilite disponibilite) {
        if (em.contains(disponibilite)) {
            em.remove(disponibilite);
        } else {
            em.remove(em.merge(disponibilite));
        }
    }

    public List<Disponibilite> findAll() {
        return em.createNamedQuery("Disponibilite.findAll", Disponibilite.class).getResultList();
    }

    public List<Disponibilite> findByDateDebut(LocalDate dateDebut) {
        return em.createNamedQuery("Disponibilite.findByDateDebut", Disponibilite.class)
                .setParameter("dateDebut", dateDebut)
                .getResultList();
    }

    public List<Disponibilite> findByDateFin(LocalDate dateFin) {
        return em.createNamedQuery("Disponibilite.findByDateFin", Disponibilite.class)
                .setParameter("dateFin", dateFin)
                .getResultList();
    }

    public Disponibilite findById(Integer id) {
        return em.find(Disponibilite.class, id);
    }
}