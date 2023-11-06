package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "interesse", schema = "projet")
public class Interesse {
    @EmbeddedId
    private InteresseId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("idEcole")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEcole", nullable = false)
    private Ecole idEcole;

    public InteresseId getId() {
        return id;
    }

    public void setId(InteresseId id) {
        this.id = id;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Ecole getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(Ecole idEcole) {
        this.idEcole = idEcole;
    }

}