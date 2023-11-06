package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jouit", schema = "projet")
public class Jouit {
    @EmbeddedId
    private JouitId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("nomTitre")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nomTitre", nullable = false)
    private Titre nomTitre;

    public JouitId getId() {
        return id;
    }

    public void setId(JouitId id) {
        this.id = id;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Titre getNomTitre() {
        return nomTitre;
    }

    public void setNomTitre(Titre nomTitre) {
        this.nomTitre = nomTitre;
    }

}