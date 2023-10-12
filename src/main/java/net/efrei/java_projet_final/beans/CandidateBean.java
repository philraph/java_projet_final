package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.EnseignantEntity;
import net.efrei.java_projet_final.entities.OffreEntity;
import net.efrei.java_projet_final.entities.associations.CandidateEntity;

import java.util.List;

@Stateless
public class CandidateBean {

    @PersistenceContext()
    private EntityManager em;

    public void create(CandidateEntity candidate) {
        em.persist(candidate);
    }

    public void update(CandidateEntity candidate) {
        em.merge(candidate);
    }

    public void delete(CandidateEntity candidate) {
        em.remove(candidate);
    }

    public List<CandidateEntity> findAll() {
        return em.createNamedQuery("CandidateEntity.findAll", CandidateEntity.class).getResultList();
    }

    public CandidateEntity findById(Integer id) {
        return em.find(CandidateEntity.class, id);
    }

    public CandidateEntity findByEnseignant(EnseignantEntity enseignant) {
        TypedQuery<CandidateEntity> query = em.createNamedQuery("CandidateEntity.findByEnseignant", CandidateEntity.class);
        query.setParameter("enseignant", enseignant);
        List<CandidateEntity> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public CandidateEntity findByOffre(OffreEntity offre) {
        TypedQuery<CandidateEntity> query = em.createNamedQuery("CandidateEntity.findByOffre", CandidateEntity.class);
        query.setParameter("offre", offre);
        List<CandidateEntity> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public List<CandidateEntity> findByContactPar(String contactPar) {
        TypedQuery<CandidateEntity> query = em.createNamedQuery("CandidateEntity.findByContactPar", CandidateEntity.class);
        query.setParameter("contactPar", contactPar);
        return query.getResultList();
    }

    public List<CandidateEntity> findByContactLe(String contactLe) {
        TypedQuery<CandidateEntity> query = em.createNamedQuery("CandidateEntity.findByContactLe", CandidateEntity.class);
        query.setParameter("contactLe", contactLe);
        return query.getResultList();
    }

    public List<CandidateEntity> findByDecision(String decision) {
        TypedQuery<CandidateEntity> query = em.createNamedQuery("CandidateEntity.findByDecision", CandidateEntity.class);
        query.setParameter("decision", decision);
        return query.getResultList();
    }

}
