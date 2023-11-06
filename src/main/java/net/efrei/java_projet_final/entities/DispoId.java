package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DispoId implements Serializable {
    private static final long serialVersionUID = 3111385105221064588L;
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;

    @Column(name = "idDispo", nullable = false)
    private Integer idDispo;

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Integer getIdDispo() {
        return idDispo;
    }

    public void setIdDispo(Integer idDispo) {
        this.idDispo = idDispo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DispoId entity = (DispoId) o;
        return Objects.equals(this.idDispo, entity.idDispo) &&
                Objects.equals(this.idEnseignant, entity.idEnseignant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDispo, idEnseignant);
    }

}