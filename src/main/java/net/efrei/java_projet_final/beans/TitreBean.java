package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.entities.Titre;

import java.util.List;

@Stateless
public class TitreBean extends AbstractBean<Titre> {

    public List<Titre> findAll() {
        return em.createNamedQuery("Titre.findAll", Titre.class).getResultList();
    }

    public Titre findByNomTitre(String nomTitre) {
        List<Titre> results = em.createNamedQuery("Titre.findByNomTitre", Titre.class)
                .setParameter("nomTitre", nomTitre)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

}

