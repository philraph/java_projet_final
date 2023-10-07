package net.efrei.java_projet_final;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "demande", schema = "projet", catalog = "")
@jakarta.persistence.IdClass(net.efrei.java_projet_final.DemandeEntityPK.class)
public class DemandeEntity {
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "idOffre", nullable = false)
    private int idOffre;

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemandeEntity that = (DemandeEntity) o;

        if (idOffre != that.idOffre) return false;
        if (competence != null ? !competence.equals(that.competence) : that.competence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = competence != null ? competence.hashCode() : 0;
        result = 31 * result + idOffre;
        return result;
    }
}
