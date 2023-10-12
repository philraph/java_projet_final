package net.efrei.java_projet_final.entities.associations;

import jakarta.persistence.*;
import net.efrei.java_projet_final.entities.EnseignantEntity;
import net.efrei.java_projet_final.entities.OffreEntity;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = CandidateEntity.TABLE_NAME)
@NamedQueries(
        {
                @NamedQuery(name = "CandidateEntity.findAll", query = "SELECT c FROM CandidateEntity c"),
                @NamedQuery(name = "CandidateEntity.findByEnseignant", query = "SELECT c FROM CandidateEntity c WHERE c.enseignant = :enseignant"),
                @NamedQuery(name = "CandidateEntity.findByOffre", query = "SELECT c FROM CandidateEntity c WHERE c.offre = :offre"),
                @NamedQuery(name = "CandidateEntity.findByContactPar", query = "SELECT c FROM CandidateEntity c WHERE c.contactPar = :contactPar"),
                @NamedQuery(name = "CandidateEntity.findByContactLe", query = "SELECT c FROM CandidateEntity c WHERE c.contactLe = :contactLe"),
                @NamedQuery(name = "CandidateEntity.findByDecision", query = "SELECT c FROM CandidateEntity c WHERE c.decision = :decision")
        }
)
public class CandidateEntity implements Serializable {
    public static final String TABLE_NAME = "candidate";

    @Id
    @OneToOne
    @JoinColumn(name = "idEnseignant")
    private EnseignantEntity enseignant;

    @Id
    @OneToOne
    @JoinColumn(name = "idOffre")
    private OffreEntity offre;

    @Column(name = "contactPar")
    private String contactPar;

    @Column(name = "contactLe")
    private String contactLe;

    @Column(name = "decision")
    private String decision;

    public EnseignantEntity getEnseignant() {
        return enseignant;
    }

    public OffreEntity getOffre() {
        return offre;
    }

    public String getContactLe() {
        return contactLe;
    }

    public String getContactPar() {
        return contactPar;
    }

    public String getDecision() {
        return decision;
    }

    public void setContactLe(String contactLe) {
        this.contactLe = contactLe;
    }

    public void setContactPar(String contactPar) {
        this.contactPar = contactPar;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public void setEnseignant(EnseignantEntity enseignant) {
        this.enseignant = enseignant;
    }

    public void setOffre(OffreEntity offre) {
        this.offre = offre;
    }

    @Override
    public String toString() {
        return "CandidateEntity{" +
                "enseignant=" + enseignant +
                ", offre=" + offre +
                ", contactPar='" + contactPar + '\'' +
                ", contactLe='" + contactLe + '\'' +
                ", decision='" + decision + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateEntity)) return false;
        CandidateEntity that = (CandidateEntity) o;
        return Objects.equals(enseignant, that.enseignant) && Objects.equals(offre, that.offre) && Objects.equals(contactPar, that.contactPar) && Objects.equals(contactLe, that.contactLe) && Objects.equals(decision, that.decision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enseignant, offre, contactPar, contactLe, decision);
    }
}
