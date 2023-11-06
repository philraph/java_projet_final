package net.efrei.java_projet_final.services;


import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.NiveauBean;
import net.efrei.java_projet_final.entities.Niveau;

import java.util.List;

@ApplicationScoped
public class NiveauService {

    @EJB
    private NiveauBean niveauBean;

    public void create(Niveau niveau) {
        niveauBean.create(niveau);
    }

    public void update(Niveau niveau) {
        niveauBean.update(niveau);
    }

    public void delete(Niveau niveau) {
        niveauBean.delete(niveau);
    }

    public Niveau findByName(String niveau) {
        return niveauBean.findByNiveau(niveau);
    }

    public List<Niveau> findAll() {
        return niveauBean.findAll();
    }

}

