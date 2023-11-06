package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.entities.Competence;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class CompetenceBean extends AbstractBean<Competence> {

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
