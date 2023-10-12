package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.beans.EcoleBean;
import net.efrei.java_projet_final.entities.EcoleEntity;

import java.util.List;

@Stateless
public class EcoleService {

    @EJB
    private EcoleBean ecoleBean;

    public void createEcole(EcoleEntity ecole) {
        ecoleBean.create(ecole);
    }

    public List<EcoleEntity> getAllEcoles() {
        return ecoleBean.findAll();
    }

    public EcoleEntity getEcoleById(Integer id) {
        return ecoleBean.findById(id);
    }

    public EcoleEntity findByRaisonSociale(String raisonSociale) {
        return ecoleBean.findByRaisonSociale(raisonSociale);
    }

    public EcoleEntity findByUsername(String username) {
        return ecoleBean.findByUsername(username);
    }

    public void updateEcole(EcoleEntity ecole) {
        ecoleBean.update(ecole);
    }

    public void deleteEcole(EcoleEntity ecole) {
        ecoleBean.delete(ecole);
    }
}
