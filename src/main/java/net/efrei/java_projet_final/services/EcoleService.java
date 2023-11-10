package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.beans.EcoleBean;
import net.efrei.java_projet_final.entities.Ecole;

import java.util.List;

@ApplicationScoped
public class EcoleService {

    @EJB
    private EcoleBean ecoleBean;

    public void create(Ecole ecole) {
        ecoleBean.create(ecole);
    }

    public void update(Ecole ecole) {
        ecoleBean.update(ecole);
    }

    public void delete(Ecole ecole) {
        ecoleBean.delete(ecole);
    }

    public List<Ecole> findAll() {
        return ecoleBean.findAll();
    }

    public Ecole findById(Integer id) {
        return ecoleBean.findById(id);
    }

    public Ecole findByRaisonSociale(String raisonSociale) {
        return ecoleBean.findByRaisonSociale(raisonSociale);
    }

    public Ecole findByUserIdentifier(String userIdentifier) {
        return ecoleBean.findByUserIdentifier(userIdentifier);
    }

    public Ecole findByUsername(String username) {
        return ecoleBean.findByUsername(username);
    }

}
