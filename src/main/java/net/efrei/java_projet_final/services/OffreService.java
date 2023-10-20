package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.OffreBean;
import net.efrei.java_projet_final.entities.EcoleEntity;
import net.efrei.java_projet_final.entities.OffreEntity;

import java.util.List;

@ApplicationScoped
public class OffreService {

    @EJB
    private OffreBean offreBean;

    public void create(OffreEntity offre) {
        offreBean.create(offre);
    }

    public void update(OffreEntity offre) {
        offreBean.update(offre);
    }

    public void delete(OffreEntity offre) {
        offreBean.delete(offre);
    }

    public OffreEntity findById(Integer id) {
        return offreBean.findById(id);
    }

    public List<OffreEntity> findAll() {
        return offreBean.findAll();
    }

    public List<OffreEntity> findByExigences(String exigences) {
        return offreBean.findByExigences(exigences);
    }

    public List<OffreEntity> findByRemarques(String remarques) {
        return offreBean.findByRemarques(remarques);
    }

    public List<OffreEntity> findByEcole(EcoleEntity ecole) {
        return offreBean.findByEcole(ecole);
    }


}
