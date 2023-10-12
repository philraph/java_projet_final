package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = TitreEntity.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = "TitreEntity.findAll", query = "SELECT t FROM TitreEntity t"),
        @NamedQuery(name = "TitreEntity.findByNomTitre", query = "SELECT t FROM TitreEntity t WHERE t.nomTitre = :nomTitre")
})
public class TitreEntity implements Serializable {
    public static final String TABLE_NAME = "Titre";

    @Id
    @Column(name = "nomTitre", nullable = false)
    private String nomTitre;

    public String getNomTitre() {
        return nomTitre;
    }

    public void setNomTitre(String nomTitre) {
        this.nomTitre = nomTitre;
    }

    @Override
    public String toString() {
        return "TitreEntity{" +
                "nomTitre='" + nomTitre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitreEntity)) return false;
        TitreEntity that = (TitreEntity) o;
        return Objects.equals(nomTitre, that.nomTitre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomTitre);
    }
}
