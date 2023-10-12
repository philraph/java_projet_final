package net.efrei.java_projet_final.services;


import jakarta.ejb.EJB;
import net.efrei.java_projet_final.beans.NiveauBean;
import net.efrei.java_projet_final.entities.NiveauEntity;

import java.util.List;

public class NiveauService {

    @EJB
    private NiveauBean niveauBean;

    public void create(NiveauEntity niveau) {
        niveauBean.create(niveau);
    }

    public void update(NiveauEntity niveau) {
        niveauBean.update(niveau);
    }

    public void delete(NiveauEntity niveau) {
        niveauBean.delete(niveau);
    }

    public NiveauEntity findByName(String niveau) {
        return niveauBean.findByNiveau(niveau);
    }

    public List<NiveauEntity> findAll() {
        return niveauBean.findAll();
    }

}

