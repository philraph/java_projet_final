package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.entities.Niveau;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class NiveauBean extends AbstractBean {

    public void create(Niveau niveau) {
        TransactionalOperation.execute(em, () -> em.persist(niveau));
    }

    public void update(Niveau niveau) {
        TransactionalOperation.execute(em, () -> em.merge(niveau));
    }

    public void delete(Niveau niveau) {
        TransactionalOperation.execute(em, () -> {
            if (em.contains(niveau)) {
                em.remove(niveau);
            } else {
                em.remove(em.merge(niveau));
            }
        });
    }

    public Niveau findByNiveau(String niveau) {
        List<Niveau> result = em.createNamedQuery("Niveau.findByNiveau", Niveau.class).setParameter("niveau", niveau).getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public List<Niveau> findAll() {
        return em.createNamedQuery("Niveau.findAll", Niveau.class).getResultList();
    }

}
