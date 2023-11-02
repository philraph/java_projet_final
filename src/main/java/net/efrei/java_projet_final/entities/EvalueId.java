package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EvalueId implements Serializable {
    private static final long serialVersionUID = 751400028820296521L;
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;

    @Column(name = "idEcole", nullable = false)
    private Integer idEcole;

    @Column(name = "competence", nullable = false)
    private String competence;

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Integer getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(Integer idEcole) {
        this.idEcole = idEcole;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvalueId entity = (EvalueId) o;
        return Objects.equals(this.competence, entity.competence) &&
                Objects.equals(this.idEcole, entity.idEcole) &&
                Objects.equals(this.idEnseignant, entity.idEnseignant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competence, idEcole, idEnseignant);
    }

}