package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.entities.Dispo;
import net.efrei.java_projet_final.entities.Disponibilite;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class DisponibiliteBean extends AbstractBean<Disponibilite> {

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