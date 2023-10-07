package net.efrei.java_projet_final;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "Niveau", schema = "projet", catalog = "")
public class NiveauEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "niveau", nullable = false, length = 255)
    private String niveau;

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

        NiveauEntity that = (NiveauEntity) o;

        if (niveau != null ? !niveau.equals(that.niveau) : that.niveau != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return niveau != null ? niveau.hashCode() : 0;
    }
}
