package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SouhaiteId implements Serializable {
    private static final long serialVersionUID = 8398077109255353174L;
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;

    @Column(name = "niveau", nullable = false)
    private String niveau;

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SouhaiteId entity = (SouhaiteId) o;
        return Objects.equals(this.idEnseignant, entity.idEnseignant) &&
                Objects.equals(this.niveau, entity.niveau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnseignant, niveau);
    }

}