package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "demande", schema = "projet")
public class Demande {
    @EmbeddedId
    private DemandeId id;

    @MapsId("competence")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "competence", nullable = false)
    private Competence competence;

    @MapsId("idOffre")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idOffre", nullable = false)
    private Offre idOffre;

    public DemandeId getId() {
        return id;
    }

    public void setId(DemandeId id) {
        this.id = id;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public Offre getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(Offre idOffre) {
        this.idOffre = idOffre;
    }

}