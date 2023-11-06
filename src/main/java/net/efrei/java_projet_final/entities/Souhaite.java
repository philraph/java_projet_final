package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "souhaite", schema = "projet")
public class Souhaite {
    @EmbeddedId
    private SouhaiteId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("niveau")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "niveau", nullable = false)
    private Niveau niveau;

    public SouhaiteId getId() {
        return id;
    }

    public void setId(SouhaiteId id) {
        this.id = id;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

}