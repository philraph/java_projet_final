package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "possede", schema = "projet")
public class Possede {
    @EmbeddedId
    private PossedeId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("competence")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "competence", nullable = false)
    private Competence competence;

    public PossedeId getId() {
        return id;
    }

    public void setId(PossedeId id) {
        this.id = id;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

}