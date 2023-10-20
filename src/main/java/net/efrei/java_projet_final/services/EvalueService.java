package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.beans.EvalueBean;
import net.efrei.java_projet_final.entities.CompetenceEntity;
import net.efrei.java_projet_final.entities.EcoleEntity;
import net.efrei.java_projet_final.entities.EnseignantEntity;
import net.efrei.java_projet_final.entities.associations.EvalueEntity;

import java.util.List;

@Stateless
public class EvalueService {

    @EJB
    private EvalueBean evalueBean;

    public void create(EvalueEntity evalue) {
        evalueBean.create(evalue);
    }

    public void update(EvalueEntity evalue) {
        evalueBean.update(evalue);
    }

    public void delete(EvalueEntity evalue) {
        evalueBean.delete(evalue);
    }

    public List<EvalueEntity> findAll() {
        return evalueBean.findAll();
    }

    public List<EvalueEntity> findByEnseignant(EnseignantEntity enseignant) {
        return evalueBean.findByEnseignant(enseignant);
    }

    public List<EvalueEntity> findByEcole(EcoleEntity ecole) {
        return evalueBean.findByEcole(ecole);
    }

    public List<EvalueEntity> findByCompetence(CompetenceEntity competence) {
        return evalueBean.findByCompetence(competence);
    }

    public List<EvalueEntity> findByNote(Integer note) {
        return evalueBean.findByNote(note);
    }

    public List<EvalueEntity> findByCommentaire(String commentaire) {
        return evalueBean.findByCommentaire(commentaire);
    }

    public List<EvalueEntity> findByEnseignantAndEcole(EnseignantEntity enseignant, EcoleEntity ecole) {
        return evalueBean.findByEnseignantAndEcole(enseignant, ecole);
    }
}

