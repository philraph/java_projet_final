package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.DisponibiliteEntity;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class DisponibiliteBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("projet").createEntityManager();

    public void create(DisponibiliteEntity disponibilite) {
        em.persist(disponibilite);
    }

    public void update(DisponibiliteEntity disponibilite) {
        em.merge(disponibilite);
    }

    public void delete(DisponibiliteEntity disponibilite) {
        if (em.contains(disponibilite)) {
            em.remove(disponibilite);
        } else {
            em.remove(em.merge(disponibilite));
        }
    }

    public List<DisponibiliteEntity> findAll() {
        return em.createNamedQuery("DisponibiliteEntity.findAll", DisponibiliteEntity.class).getResultList();
    }

    public List<DisponibiliteEntity> findByDateDebut(LocalDate dateDebut) {
        return em.createNamedQuery("DisponibiliteEntity.findByDateDebut", DisponibiliteEntity.class)
                .setParameter("dateDebut", dateDebut)
                .getResultList();
    }

    public List<DisponibiliteEntity> findByDateFin(LocalDate dateFin) {
        return em.createNamedQuery("DisponibiliteEntity.findByDateFin", DisponibiliteEntity.class)
                .setParameter("dateFin", dateFin)
                .getResultList();
    }

    public DisponibiliteEntity findById(Integer id) {
        return em.find(DisponibiliteEntity.class, id);
    }
}