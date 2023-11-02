package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DemandeId implements Serializable {
    private static final long serialVersionUID = 4554548277399604057L;
    @Column(name = "competence", nullable = false)
    private String competence;

    @Column(name = "idOffre", nullable = false)
    private Integer idOffre;

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public Integer getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(Integer idOffre) {
        this.idOffre = idOffre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeId entity = (DemandeId) o;
        return Objects.equals(this.competence, entity.competence) &&
                Objects.equals(this.idOffre, entity.idOffre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competence, idOffre);
    }

}