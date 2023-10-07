package net.efrei.java_projet_final;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "Titre", schema = "projet", catalog = "")
public class TitreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "nomTitre", nullable = false, length = 255)
    private String nomTitre;

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

        TitreEntity that = (TitreEntity) o;

        if (nomTitre != null ? !nomTitre.equals(that.nomTitre) : that.nomTitre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nomTitre != null ? nomTitre.hashCode() : 0;
    }
}
