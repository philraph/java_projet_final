package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.OffreBean;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Offre;

import java.util.List;

@ApplicationScoped
public class OffreService {

    @EJB
    private OffreBean offreBean;

    public void create(Offre offre) {
        offreBean.create(offre);
    }

    public void update(Offre offre) {
        offreBean.update(offre);
    }

    public void delete(Offre offre) {
        offreBean.delete(offre);
    }

    public Offre findById(Integer id) {
        return offreBean.findById(id);
    }

    public List<Offre> findAll() {
        return offreBean.findAll();
    }

    public List<Offre> findByExigences(String exigences) {
        return offreBean.findByExigences(exigences);
    }

    public List<Offre> findByRemarques(String remarques) {
        return offreBean.findByRemarques(remarques);
    }

    public List<Offre> findByEcole(Ecole ecole) {
        return offreBean.findByEcole(ecole);
    }


}
