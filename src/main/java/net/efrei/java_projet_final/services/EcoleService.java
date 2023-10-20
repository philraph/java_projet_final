package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Singleton;
import net.efrei.java_projet_final.beans.EcoleBean;
import net.efrei.java_projet_final.entities.EcoleEntity;

import java.util.List;

@Stateless
public class EcoleService {

    @EJB
    private EcoleBean ecoleBean;

    public void create(EcoleEntity ecole) {
        ecoleBean.create(ecole);
    }

    public void update(EcoleEntity ecole) {
        ecoleBean.update(ecole);
    }

    public void delete(EcoleEntity ecole) {
        ecoleBean.delete(ecole);
    }

    public List<EcoleEntity> findAll() {
        return ecoleBean.findAll();
    }

    public EcoleEntity findById(Integer id) {
        return ecoleBean.findById(id);
    }

    public EcoleEntity findByRaisonSociale(String raisonSociale) {
        return ecoleBean.findByRaisonSociale(raisonSociale);
    }

    public EcoleEntity findByUsername(String username) {
        return ecoleBean.findByUsername(username);
    }

}
