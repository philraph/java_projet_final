package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.CompetenceEntity;
import net.efrei.java_projet_final.entities.EcoleEntity;
import net.efrei.java_projet_final.entities.EnseignantEntity;
import net.efrei.java_projet_final.entities.associations.EvalueEntity;

import java.util.List;

@Stateless
public class EvalueBean {

    @PersistenceContext()
    private EntityManager em = Persistence.createEntityManagerFactory("projet").createEntityManager();

    public void create(EvalueEntity evalue) {
        em.persist(evalue);
    }

    public void update(EvalueEntity evalue) {
        em.merge(evalue);
    }

    public void delete(EvalueEntity evalue) {
        em.remove(evalue);
    }

    public List<EvalueEntity> findAll() {
        return em.createNamedQuery("EvalueEntity.findAll", EvalueEntity.class).getResultList();
    }

    public List<EvalueEntity> findByEnseignant(EnseignantEntity enseignant) {
        TypedQuery<EvalueEntity> query = em.createNamedQuery("EvalueEntity.findByEnseignant", EvalueEntity.class);
        query.setParameter("enseignant", enseignant);
        return query.getResultList();
    }

    public List<EvalueEntity> findByEcole(EcoleEntity ecole) {
        TypedQuery<EvalueEntity> query = em.createNamedQuery("EvalueEntity.findByEcole", EvalueEntity.class);
        query.setParameter("ecole", ecole);
        return query.getResultList();
    }

    public List<EvalueEntity> findByCompetence(CompetenceEntity competence) {
        TypedQuery<EvalueEntity> query = em.createNamedQuery("EvalueEntity.findByCompetence", EvalueEntity.class);
        query.setParameter("competence", competence);
        return query.getResultList();
    }

    public List<EvalueEntity> findByNote(Integer note) {
        TypedQuery<EvalueEntity> query = em.createNamedQuery("EvalueEntity.findByNote", EvalueEntity.class);
        query.setParameter("note", note);
        return query.getResultList();
    }

    public List<EvalueEntity> findByCommentaire(String commentaire) {
        TypedQuery<EvalueEntity> query = em.createNamedQuery("EvalueEntity.findByCommentaire", EvalueEntity.class);
        query.setParameter("commentaire", commentaire);
        return query.getResultList();
    }

    public List<EvalueEntity> findByEnseignantAndEcole(EnseignantEntity enseignant, EcoleEntity ecole) {
        TypedQuery<EvalueEntity> query = em.createNamedQuery("EvalueEntity.findByEnseignantAndEcole", EvalueEntity.class);
        query.setParameter("enseignant", enseignant);
        query.setParameter("ecole", ecole);
        return query.getResultList();
    }
}
