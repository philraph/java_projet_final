package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.Competence;

import java.util.List;

@Stateless
public class CompetenceBean {

    @PersistenceContext()
    private EntityManager em;

    public void create(Competence competence) {
        em.persist(competence);
    }

    public void update(Competence competence) {
        em.merge(competence);
    }

    public void delete(Competence competence) {
        if (em.contains(competence)) {
            em.remove(competence);
        } else {
            em.remove(em.merge(competence));
        }
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
