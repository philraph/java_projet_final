package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Typed;
import net.efrei.java_projet_final.beans.CandidateBean;
import net.efrei.java_projet_final.entities.Ecole;
import net.efrei.java_projet_final.entities.Enseignant;
import net.efrei.java_projet_final.entities.Offre;
import net.efrei.java_projet_final.entities.Candidate;

import java.util.List;

@ApplicationScoped
public class CandidateService {

    @EJB
    private CandidateBean candidateBean;

    public void create(Candidate candidate) {
        candidateBean.create(candidate);
    }

    public void update(Candidate candidate) {
        candidateBean.update(candidate);
    }

    public void delete(Candidate candidate) {
        candidateBean.delete(candidate);
    }

    public List<Candidate> findAll() {
        return candidateBean.findAll();
    }

    public Candidate findById(Integer id) {
        return candidateBean.findById(id);
    }

    public Candidate findByEnseignant(Enseignant enseignant) {
        return candidateBean.findByEnseignant(enseignant);
    }

    public Candidate findByOffre(Offre offre) {
        return candidateBean.findByOffre(offre);
    }

    public List<Candidate> findByContactPar(String contactPar) {
        return candidateBean.findByContactPar(contactPar);
    }

    public List<Candidate> findByContactLe(String contactLe) {
        return candidateBean.findByContactLe(contactLe);
    }

    public List<Candidate> findByDecision(String decision) {
        return candidateBean.findByDecision(decision);
    }

    public List<Candidate> findByEcole(Ecole ecole) {
        return candidateBean.findByEcole(ecole);
    }

}

