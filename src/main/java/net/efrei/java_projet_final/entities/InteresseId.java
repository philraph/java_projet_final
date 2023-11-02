package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InteresseId implements Serializable {
    private static final long serialVersionUID = -6281968532054733027L;
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;

    @Column(name = "idEcole", nullable = false)
    private Integer idEcole;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteresseId entity = (InteresseId) o;
        return Objects.equals(this.idEcole, entity.idEcole) &&
                Objects.equals(this.idEnseignant, entity.idEnseignant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEcole, idEnseignant);
    }

}