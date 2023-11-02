package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recommandeEnseignant", schema = "projet")
public class RecommandeEnseignant {
    @EmbeddedId
    private RecommandeEnseignantId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("idEnseignantRecommande")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignantRecommande", nullable = false)
    private Enseignant idEnseignantRecommande;

    @MapsId("competence")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "competence", nullable = false)
    private Competence competence;

    @Column(name = "commentaire")
    private String commentaire;

    public RecommandeEnseignantId getId() {
        return id;
    }

    public void setId(RecommandeEnseignantId id) {
        this.id = id;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Enseignant getIdEnseignantRecommande() {
        return idEnseignantRecommande;
    }

    public void setIdEnseignantRecommande(Enseignant idEnseignantRecommande) {
        this.idEnseignantRecommande = idEnseignantRecommande;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

}