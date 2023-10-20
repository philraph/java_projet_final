package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import net.efrei.java_projet_final.entities.CompetenceEntity;

import java.util.List;

@Stateless
public class CompetenceBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("projet").createEntityManager();

    public void create(CompetenceEntity competence) {
        em.persist(competence);
    }

    public void update(CompetenceEntity competence) {
        em.merge(competence);
    }

    public void delete(CompetenceEntity competence) {
        if (em.contains(competence)) {
            em.remove(competence);
        } else {
            em.remove(em.merge(competence));
        }
    }

    public CompetenceEntity findById(Integer id) {
        return em.find(CompetenceEntity.class, id);
    }

    public List<CompetenceEntity> findAll() {
        return em.createNamedQuery("CompetenceEntity.findAll", CompetenceEntity.class).getResultList();
    }

    public List<CompetenceEntity> findByCompetence(String competence) {
        return em.createNamedQuery("CompetenceEntity.findByCompetence", CompetenceEntity.class).setParameter("competence", competence).getResultList();
    }

}
