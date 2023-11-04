package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.Candidate;
import net.efrei.java_projet_final.entities.Enseignant;
import net.efrei.java_projet_final.entities.Offre;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class CandidateBean extends AbstractBean {

    public void create(Candidate candidate) {
        TransactionalOperation.execute(em, () -> em.persist(candidate));
    }

    public void update(Candidate candidate) {
        TransactionalOperation.execute(em, () -> em.merge(candidate));
    }

    public void delete(Candidate candidate) {
        TransactionalOperation.execute(em, () -> {
            if (em.contains(candidate)) {
                em.remove(candidate);
            } else {
                em.remove(em.merge(candidate));
            }
        });
    }


    public List<Candidate> findAll() {
        return em.createNamedQuery("Candidate.findAll", Candidate.class).getResultList();
    }

    public Candidate findById(Integer id) {
        return em.find(Candidate.class, id);
    }

    public Candidate findByEnseignant(Enseignant enseignant) {
        TypedQuery<Candidate> query = em.createNamedQuery("Candidate.findByEnseignant", Candidate.class);
        query.setParameter("enseignant", enseignant);
        List<Candidate> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public Candidate findByOffre(Offre offre) {
        TypedQuery<Candidate> query = em.createNamedQuery("Candidate.findByOffre", Candidate.class);
        query.setParameter("offre", offre);
        List<Candidate> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public List<Candidate> findByContactPar(String contactPar) {
        TypedQuery<Candidate> query = em.createNamedQuery("Candidate.findByContactPar", Candidate.class);
        query.setParameter("contactPar", contactPar);
        return query.getResultList();
    }

    public List<Candidate> findByContactLe(String contactLe) {
        TypedQuery<Candidate> query = em.createNamedQuery("Candidate.findByContactLe", Candidate.class);
        query.setParameter("contactLe", contactLe);
        return query.getResultList();
    }

    public List<Candidate> findByDecision(String decision) {
        TypedQuery<Candidate> query = em.createNamedQuery("Candidate.findByDecision", Candidate.class);
        query.setParameter("decision", decision);
        return query.getResultList();
    }

}
