package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "evalue", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Evalue.findAll", query = "SELECT e FROM Evalue e"),
        @NamedQuery(name = "Evalue.findByEnseignant", query = "SELECT e FROM Evalue e WHERE e.idEnseignant = :enseignant"),
        @NamedQuery(name = "Evalue.findByEcole", query = "SELECT e FROM Evalue e WHERE e.idEcole = :ecole"),
        @NamedQuery(name = "Evalue.findByCompetence", query = "SELECT e FROM Evalue e WHERE e.competence = :competence"),
        @NamedQuery(name = "Evalue.findByNote", query = "SELECT e FROM Evalue e WHERE e.note = :note"),
        @NamedQuery(name = "Evalue.findByCommentaire", query = "SELECT e FROM Evalue e WHERE e.commentaire = :commentaire"),
        @NamedQuery(name = "Evalue.findByEnseignantAndEcole", query = "SELECT e FROM Evalue e WHERE e.idEnseignant = :enseignant AND e.idEcole = :ecole")
})
public class Evalue {
    @EmbeddedId
    private EvalueId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("idEcole")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEcole", nullable = false)
    private Ecole idEcole;

    @MapsId("competence")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "competence", nullable = false)
    private Competence competence;

    @Column(name = "note")
    private Integer note;

    @Column(name = "commentaire")
    private String commentaire;

    public EvalueId getId() {
        return id;
    }

    public void setId(EvalueId id) {
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

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

}