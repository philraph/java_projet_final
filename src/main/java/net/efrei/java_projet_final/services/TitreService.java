package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.TitreBean;
import net.efrei.java_projet_final.entities.TitreEntity;

import java.util.List;

@ApplicationScoped
public class TitreService {

    @EJB
    private TitreBean titreBean;

    public void create(TitreEntity titre) {
        titreBean.create(titre);
    }

    public void update(TitreEntity titre) {
        titreBean.update(titre);
    }

    public void delete(TitreEntity titre) {
        titreBean.delete(titre);
    }

    public TitreEntity findByName(String nomTitre) {
        return titreBean.findByNomTitre(nomTitre);
    }

    public List<TitreEntity> findAll() {
        return titreBean.findAll();
    }

}

