package net.efrei.java_projet_final.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import net.efrei.java_projet_final.beans.CompetenceBean;
import net.efrei.java_projet_final.entities.CompetenceEntity;

import java.util.List;

@Stateless
public class CompetenceService {

    @EJB
    private CompetenceBean competenceBean;

    public void create(CompetenceEntity competence) {
        competenceBean.create(competence);
    }

    public void update(CompetenceEntity competence) {
        competenceBean.update(competence);
    }

    public void delete(CompetenceEntity competence) {
        competenceBean.delete(competence);
    }

    public CompetenceEntity findById(Integer id) {
        return competenceBean.findById(id);
    }

    public List<CompetenceEntity> findAll() {
        return competenceBean.findAll();
    }

    public List<CompetenceEntity> findByCompetence(String competence) {
        return competenceBean.findByCompetence(competence);
    }
}

