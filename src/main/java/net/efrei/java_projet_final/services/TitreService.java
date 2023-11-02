package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.TitreBean;
import net.efrei.java_projet_final.entities.Titre;

import java.util.List;

@ApplicationScoped
public class TitreService {

    @EJB
    private TitreBean titreBean;

    public void create(Titre titre) {
        titreBean.create(titre);
    }

    public void update(Titre titre) {
        titreBean.update(titre);
    }

    public void delete(Titre titre) {
        titreBean.delete(titre);
    }

    public Titre findByName(String nomTitre) {
        return titreBean.findByNomTitre(nomTitre);
    }

    public List<Titre> findAll() {
        return titreBean.findAll();
    }

}

