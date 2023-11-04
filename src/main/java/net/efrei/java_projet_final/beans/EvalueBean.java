package net.efrei.java_projet_final.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import net.efrei.java_projet_final.entities.Competence;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Enseignant;
import net.efrei.java_projet_final.entities.Evalue;
import net.efrei.java_projet_final.utils.TransactionalOperation;

import java.util.List;

@Stateless
public class EvalueBean extends AbstractBean {

    public void create(Evalue evalue) {
        TransactionalOperation.execute(em, () -> em.persist(evalue));
    }

    public void update(Evalue evalue) {
        TransactionalOperation.execute(em, () -> em.merge(evalue));
    }

    public void delete(Evalue evalue) {
        TransactionalOperation.execute(em, () -> {
            if (em.contains(evalue)) {
                em.remove(evalue);
            } else {
                em.remove(em.merge(evalue));
            }
        });
    }

    public List<Evalue> findAll() {
        return em.createNamedQuery("Evalue.findAll", Evalue.class).getResultList();
    }

    public List<Evalue> findByEnseignant(Enseignant enseignant) {
        TypedQuery<Evalue> query = em.createNamedQuery("Evalue.findByEnseignant", Evalue.class);
        query.setParameter("enseignant", enseignant);
        return query.getResultList();
    }

    public List<Evalue> findByEcole(Ecole ecole) {
        TypedQuery<Evalue> query = em.createNamedQuery("Evalue.findByEcole", Evalue.class);
        query.setParameter("ecole", ecole);
        return query.getResultList();
    }

    public List<Evalue> findByCompetence(Competence competence) {
        TypedQuery<Evalue> query = em.createNamedQuery("Evalue.findByCompetence", Evalue.class);
        query.setParameter("competence", competence);
        return query.getResultList();
    }

    public List<Evalue> findByNote(Integer note) {
        TypedQuery<Evalue> query = em.createNamedQuery("Evalue.findByNote", Evalue.class);
        query.setParameter("note", note);
        return query.getResultList();
    }

    public List<Evalue> findByCommentaire(String commentaire) {
        TypedQuery<Evalue> query = em.createNamedQuery("Evalue.findByCommentaire", Evalue.class);
        query.setParameter("commentaire", commentaire);
        return query.getResultList();
    }

    public List<Evalue> findByEnseignantAndEcole(Enseignant enseignant, Ecole ecole) {
        TypedQuery<Evalue> query = em.createNamedQuery("Evalue.findByEnseignantAndEcole", Evalue.class);
        query.setParameter("enseignant", enseignant);
        query.setParameter("ecole", ecole);
        return query.getResultList();
    }
}
