package net.efrei.java_projet_final.entities.associations;

import jakarta.persistence.*;
import net.efrei.java_projet_final.entities.CompetenceEntity;
import net.efrei.java_projet_final.entities.EcoleEntity;
import net.efrei.java_projet_final.entities.EnseignantEntity;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = EvalueEntity.TABLE_NAME)
public class EvalueEntity implements Serializable {
    public static final String TABLE_NAME = "evalue";

    @Id
    @ManyToOne
    @JoinColumn(name = "idEnseignant")
    private EnseignantEntity enseignant;

    @Id
    @ManyToOne
    @JoinColumn(name = "idEcole")
    private EcoleEntity ecole;

    @Id
    @ManyToOne
    @JoinColumn(name = "competence")
    private CompetenceEntity competence;

    @Column(name = "note")
    private Integer note;

    @Column(name = "commentaire")
    private String commentaire;

    public EcoleEntity getEcole() {
        return ecole;
    }

    public CompetenceEntity getCompetence() {
        return competence;
    }

    public EnseignantEntity getEnseignant() {
        return enseignant;
    }

    public Integer getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setEnseignant(EnseignantEntity enseignant) {
        this.enseignant = enseignant;
    }

    public void setCompetence(CompetenceEntity competence) {
        this.competence = competence;
    }

    public void setEcole(EcoleEntity ecole) {
        this.ecole = ecole;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "EvalueEntity{" +
                "enseignant=" + enseignant +
                ", ecole=" + ecole +
                ", competence=" + competence +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EvalueEntity)) return false;
        EvalueEntity that = (EvalueEntity) o;
        return Objects.equals(enseignant, that.enseignant) && Objects.equals(ecole, that.ecole) && Objects.equals(competence, that.competence) && Objects.equals(note, that.note) && Objects.equals(commentaire, that.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enseignant, ecole, competence, note, commentaire);
    }
}

