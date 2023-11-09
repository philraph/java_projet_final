package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class EcoleBean extends AbstractBean<Ecole> {

    public List<Ecole> findAll() {
        TypedQuery<Ecole> query = em.createNamedQuery("Ecole.findAll", Ecole.class);
        return query.getResultList();
    }

    public Ecole findById(Integer id) {
        return em.find(Ecole.class, id);
    }

    public Ecole findByRaisonSociale(String raisonSociale) {
        TypedQuery<Ecole> query = em.createNamedQuery("Ecole.findByRaisonSociale", Ecole.class);
        query.setParameter("raisonSociale", raisonSociale);
        return query.getResultStream().findFirst().orElse(null);
    }

    public Ecole findByUsername(String username) {
        TypedQuery<Ecole> query = em.createNamedQuery("Ecole.findByUsername", Ecole.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst().orElse(null);
    }
}
