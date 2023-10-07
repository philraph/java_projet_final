package net.efrei.java_projet_final;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "Competence", schema = "projet", catalog = "")
public class CompetenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "competence", nullable = false, length = 255)
    private String competence;

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

        CompetenceEntity that = (CompetenceEntity) o;

        if (competence != null ? !competence.equals(that.competence) : that.competence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return competence != null ? competence.hashCode() : 0;
    }
}
