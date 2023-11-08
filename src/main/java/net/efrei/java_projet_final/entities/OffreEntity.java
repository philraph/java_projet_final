package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = OffreEntity.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = "OffreEntity.findAll", query = "SELECT o FROM OffreEntity o"),
        @NamedQuery(name = "OffreEntity.findByExigences", query = "SELECT o FROM OffreEntity o WHERE o.exigences = :exigences"),
        @NamedQuery(name = "OffreEntity.findByRemarques", query = "SELECT o FROM OffreEntity o WHERE o.remarques = :remarques"),
        @NamedQuery(name = "OffreEntity.findByEcole", query = "SELECT o FROM OffreEntity o WHERE o.ecole.raisonSociale = :raisonsociale"),
})
public class OffreEntity implements Serializable {
    public static final String TABLE_NAME = "Offre";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "exigences")
    private String exigences;

    @Column(name = "remarques")
    private String remarques;

    @ManyToOne
    @JoinColumn(name = "idDispo", nullable = false)
    private Disponibilite disponibilite;

    @ManyToOne
    @JoinColumn(name = "idEcole", nullable = false)
    private Ecole ecole;

    public Integer getId() {
        return id;
    }

    public String getExigences() {
        return exigences;
    }

    public String getRemarques() {
        return remarques;
    }

    public Disponibilite getDisponibilite() {
        return disponibilite;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setExigences(String exigences) {
        this.exigences = exigences;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public void setDisponibilite(Disponibilite disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }


    @Override
    public String toString() {
        return "OffreEntity{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", exigences='" + exigences + '\'' +
                ", remarques='" + remarques + '\'' +
                ", disponibilite=" + disponibilite +
                ", ecole=" + ecole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OffreEntity)) return false;
        OffreEntity that = (OffreEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(exigences, that.exigences) && Objects.equals(remarques, that.remarques) && Objects.equals(disponibilite, that.disponibilite) && Objects.equals(ecole, that.ecole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exigences, remarques, disponibilite, ecole);
    }
}

