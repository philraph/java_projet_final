package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.entities.Competence;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class CompetenceBean extends AbstractBean {

    public void create(Competence competence) {
        TransactionalOperation.execute(em, () -> em.persist(competence));
    }

    public void update(Competence competence) {
        TransactionalOperation.execute(em, () -> em.merge(competence));
    }

    public void delete(Competence competence) {
        TransactionalOperation.execute(em, () -> {
            if (em.contains(competence)) {
                em.remove(competence);
            } else {
                em.remove(em.merge(competence));
            }
        });
    }

    public Competence findById(Integer id) {
        return em.find(Competence.class, id);
    }

    public List<Competence> findAll() {
        return em.createNamedQuery("Competence.findAll", Competence.class).getResultList();
    }

    public List<Competence> findByCompetence(String competence) {
        return em.createNamedQuery("Competence.findByCompetence", Competence.class).setParameter("competence", competence).getResultList();
    }

}
