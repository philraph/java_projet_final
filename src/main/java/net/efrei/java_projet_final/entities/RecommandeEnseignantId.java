package net.efrei.java_projet_final.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecommandeEnseignantId implements Serializable {
    private static final long serialVersionUID = -8819006284225291009L;
    @Column(name = "idEnseignant", nullable = false)
    private Integer idEnseignant;

    @Column(name = "idEnseignantRecommande", nullable = false)
    private Integer idEnseignantRecommande;

    @Column(name = "competence", nullable = false)
    private String competence;

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Integer getIdEnseignantRecommande() {
        return idEnseignantRecommande;
    }

    public void setIdEnseignantRecommande(Integer idEnseignantRecommande) {
        this.idEnseignantRecommande = idEnseignantRecommande;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommandeEnseignantId entity = (RecommandeEnseignantId) o;
        return Objects.equals(this.idEnseignantRecommande, entity.idEnseignantRecommande) &&
                Objects.equals(this.competence, entity.competence) &&
                Objects.equals(this.idEnseignant, entity.idEnseignant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnseignantRecommande, competence, idEnseignant);
    }

}