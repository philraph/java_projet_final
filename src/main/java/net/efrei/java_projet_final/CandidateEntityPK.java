package net.efrei.java_projet_final;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class CandidateEntityPK implements Serializable {
    @Column(name = "idEnseignant", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnseignant;
    @Column(name = "idOffre", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOffre;

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateEntityPK that = (CandidateEntityPK) o;

        if (idEnseignant != that.idEnseignant) return false;
        if (idOffre != that.idOffre) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEnseignant;
        result = 31 * result + idOffre;
        return result;
    }
}
