package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = CompetenceEntity.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = "CompetenceEntity.findAll", query = "SELECT c FROM CompetenceEntity c"),
        @NamedQuery(name = "CompetenceEntity.findByCompetence", query = "SELECT c FROM CompetenceEntity c WHERE c.competence = :competence"),
})
public class CompetenceEntity implements Serializable {
    public static final String TABLE_NAME = "Competence";

    @Id
    @Column(name = "competence", nullable = false)
    private String competence;

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    @Override
    public String toString() {
        return "CompetenceEntity{" +
                "competence='" + competence + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetenceEntity that = (CompetenceEntity) o;
        return Objects.equals(competence, that.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competence);
    }
}
