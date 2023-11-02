package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import net.efrei.java_projet_final.beans.CompetenceBean;
import net.efrei.java_projet_final.entities.Competence;

import java.util.List;

@ApplicationScoped
public class CompetenceService {

    @EJB
    private CompetenceBean competenceBean;

    public void create(Competence competence) {
        competenceBean.create(competence);
    }

    public void update(Competence competence) {
        competenceBean.update(competence);
    }

    public void delete(Competence competence) {
        competenceBean.delete(competence);
    }

    public Competence findById(Integer id) {
        return competenceBean.findById(id);
    }

    public List<Competence> findAll() {
        return competenceBean.findAll();
    }

    public List<Competence> findByCompetence(String competence) {
        return competenceBean.findByCompetence(competence);
    }
}

