package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dispo", schema = "projet")
public class Dispo {
    @EmbeddedId
    private DispoId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("idDispo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDispo", nullable = false)
    private Disponibilite idDispo;

    public DispoId getId() {
        return id;
    }

    public void setId(DispoId id) {
        this.id = id;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Disponibilite getIdDispo() {
        return idDispo;
    }

    public void setIdDispo(Disponibilite idDispo) {
        this.idDispo = idDispo;
    }

}