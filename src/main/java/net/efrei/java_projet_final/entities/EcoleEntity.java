package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = EcoleEntity.TABLE_NAME)
public class EcoleEntity implements Serializable {
    public static final String TABLE_NAME = "Ecole";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "raisonSociale")
    private String raisonSociale;

    @OneToOne
    @JoinColumn(name = "idUtilisateur", nullable = false, unique = true)
    private UtilisateurEntity utilisateur;

    public Integer getId() {
        return id;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    @Override
    public String toString() {
        return "EcoleEntity{" +
                "id=" + id +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EcoleEntity)) return false;
        EcoleEntity that = (EcoleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(raisonSociale, that.raisonSociale) && Objects.equals(utilisateur, that.utilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, raisonSociale, utilisateur);
    }
}
