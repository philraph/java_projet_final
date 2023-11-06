package net.efrei.java_projet_final.services;


import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.DisponibiliteBean;
import net.efrei.java_projet_final.entities.Disponibilite;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DisponibiliteService {

    @EJB
    private DisponibiliteBean disponibiliteBean;

    public void create(Disponibilite disponibilite) {
        disponibiliteBean.create(disponibilite);
    }

    public void update(Disponibilite disponibilite) {
        disponibiliteBean.update(disponibilite);
    }

    public void delete(Disponibilite disponibilite) {
        disponibiliteBean.delete(disponibilite);
    }

    public List<Disponibilite> findAll() {
        return disponibiliteBean.findAll();
    }

    public List<Disponibilite> findByDateDebut(LocalDate dateDebut) {
        return disponibiliteBean.findByDateDebut(dateDebut);
    }

    public List<Disponibilite> findByDateFin(LocalDate dateFin) {
        return disponibiliteBean.findByDateFin(dateFin);
    }

    public Disponibilite findById(Integer id) {
        return disponibiliteBean.findById(id);
    }
}

