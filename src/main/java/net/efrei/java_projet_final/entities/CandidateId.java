package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateId implements Serializable {
    private static final long serialVersionUID = 5405005953753384193L;
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;

    @Column(name = "idOffre", nullable = false)
    private Integer idOffre;

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
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
        CandidateId entity = (CandidateId) o;
        return Objects.equals(this.idEnseignant, entity.idEnseignant) &&
                Objects.equals(this.idOffre, entity.idOffre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnseignant, idOffre);
    }

}