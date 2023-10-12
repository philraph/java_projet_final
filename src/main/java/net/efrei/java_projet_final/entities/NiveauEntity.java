package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = NiveauEntity.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = "NiveauEntity.findAll", query = "SELECT n FROM NiveauEntity n"),
        @NamedQuery(name = "NiveauEntity.findByNiveau", query = "SELECT n FROM NiveauEntity n WHERE n.niveau = :niveau"),
})
public class NiveauEntity implements Serializable {
    public static final String TABLE_NAME = "Niveau";

    @Id
    @Column(name = "niveau", nullable = false)
    private String niveau;

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "NiveauEntity{" +
                "niveau='" + niveau + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NiveauEntity)) return false;
        NiveauEntity that = (NiveauEntity) o;
        return Objects.equals(niveau, that.niveau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(niveau);
    }
}
