package net.efrei.java_projet_final.services;


import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.beans.DisponibiliteBean;
import net.efrei.java_projet_final.entities.DisponibiliteEntity;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class DisponibiliteService {

    @EJB
    private DisponibiliteBean disponibiliteBean;

    public void create(DisponibiliteEntity disponibilite) {
        disponibiliteBean.create(disponibilite);
    }

    public void update(DisponibiliteEntity disponibilite) {
        disponibiliteBean.update(disponibilite);
    }

    public void delete(DisponibiliteEntity disponibilite) {
        disponibiliteBean.delete(disponibilite);
    }

    public List<DisponibiliteEntity> findAll() {
        return disponibiliteBean.findAll();
    }

    public List<DisponibiliteEntity> findByDateDebut(LocalDate dateDebut) {
        return disponibiliteBean.findByDateDebut(dateDebut);
    }

    public List<DisponibiliteEntity> findByDateFin(LocalDate dateFin) {
        return disponibiliteBean.findByDateFin(dateFin);
    }

    public DisponibiliteEntity findById(Integer id) {
        return disponibiliteBean.findById(id);
    }
}

