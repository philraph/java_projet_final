package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JouitId implements Serializable {
    private static final long serialVersionUID = 2645896445577236001L;
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;

    @Column(name = "nomTitre", nullable = false)
    private String nomTitre;

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNomTitre() {
        return nomTitre;
    }

    public void setNomTitre(String nomTitre) {
        this.nomTitre = nomTitre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JouitId entity = (JouitId) o;
        return Objects.equals(this.nomTitre, entity.nomTitre) &&
                Objects.equals(this.idEnseignant, entity.idEnseignant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomTitre, idEnseignant);
    }

}