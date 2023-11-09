package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.entities.Niveau;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class NiveauBean extends AbstractBean<Niveau> {

    public Niveau findByNiveau(String niveau) {
        List<Niveau> result = em.createNamedQuery("Niveau.findByNiveau", Niveau.class).setParameter("niveau", niveau).getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public List<Niveau> findAll() {
        return em.createNamedQuery("Niveau.findAll", Niveau.class).getResultList();
    }

}
