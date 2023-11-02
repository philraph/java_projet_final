package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.EvalueBean;
import net.efrei.java_projet_final.entities.Competence;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Enseignant;
import net.efrei.java_projet_final.entities.Evalue;

import java.util.List;

@ApplicationScoped
public class EvalueService {

    @EJB
    private EvalueBean evalueBean;

    public void create(Evalue evalue) {
        evalueBean.create(evalue);
    }

    public void update(Evalue evalue) {
        evalueBean.update(evalue);
    }

    public void delete(Evalue evalue) {
        evalueBean.delete(evalue);
    }

    public List<Evalue> findAll() {
        return evalueBean.findAll();
    }

    public List<Evalue> findByEnseignant(Enseignant enseignant) {
        return evalueBean.findByEnseignant(enseignant);
    }

    public List<Evalue> findByEcole(Ecole ecole) {
        return evalueBean.findByEcole(ecole);
    }

    public List<Evalue> findByCompetence(Competence competence) {
        return evalueBean.findByCompetence(competence);
    }

    public List<Evalue> findByNote(Integer note) {
        return evalueBean.findByNote(note);
    }

    public List<Evalue> findByCommentaire(String commentaire) {
        return evalueBean.findByCommentaire(commentaire);
    }

    public List<Evalue> findByEnseignantAndEcole(Enseignant enseignant, Ecole ecole) {
        return evalueBean.findByEnseignantAndEcole(enseignant, ecole);
    }
}

