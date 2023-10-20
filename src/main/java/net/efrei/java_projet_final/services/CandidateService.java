package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Typed;
import net.efrei.java_projet_final.beans.CandidateBean;
import net.efrei.java_projet_final.entities.EnseignantEntity;
import net.efrei.java_projet_final.entities.OffreEntity;
import net.efrei.java_projet_final.entities.associations.CandidateEntity;

import java.util.List;

@ApplicationScoped
public class CandidateService {

    @EJB
    private CandidateBean candidateBean;

    public void create(CandidateEntity candidate) {
        candidateBean.create(candidate);
    }

    public void update(CandidateEntity candidate) {
        candidateBean.update(candidate);
    }

    public void delete(CandidateEntity candidate) {
        candidateBean.delete(candidate);
    }

    public List<CandidateEntity> findAll() {
        return candidateBean.findAll();
    }

    public CandidateEntity findById(Integer id) {
        return candidateBean.findById(id);
    }

    public CandidateEntity findByEnseignant(EnseignantEntity enseignant) {
        return candidateBean.findByEnseignant(enseignant);
    }

    public CandidateEntity findByOffre(OffreEntity offre) {
        return candidateBean.findByOffre(offre);
    }

    public List<CandidateEntity> findByContactPar(String contactPar) {
        return candidateBean.findByContactPar(contactPar);
    }

    public List<CandidateEntity> findByContactLe(String contactLe) {
        return candidateBean.findByContactLe(contactLe);
    }

    public List<CandidateEntity> findByDecision(String decision) {
        return candidateBean.findByDecision(decision);
    }

}

