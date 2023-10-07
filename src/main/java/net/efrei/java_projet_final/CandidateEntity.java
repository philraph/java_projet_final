package net.efrei.java_projet_final;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "candidate", schema = "projet", catalog = "")
@IdClass(net.efrei.java_projet_final.CandidateEntityPK.class)
public class CandidateEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "idEnseignant", nullable = false)
    private int idEnseignant;

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
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

    @Basic
    @Column(name = "contactPar", nullable = true, length = 255)
    private String contactPar;

    public String getContactPar() {
        return contactPar;
    }

    public void setContactPar(String contactPar) {
        this.contactPar = contactPar;
    }

    @Basic
    @Column(name = "contactLe", nullable = true, length = 255)
    private String contactLe;

    public String getContactLe() {
        return contactLe;
    }

    public void setContactLe(String contactLe) {
        this.contactLe = contactLe;
    }

    @Basic
    @Column(name = "decision", nullable = true, length = 255)
    private String decision;

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateEntity that = (CandidateEntity) o;

        if (idEnseignant != that.idEnseignant) return false;
        if (idOffre != that.idOffre) return false;
        if (contactPar != null ? !contactPar.equals(that.contactPar) : that.contactPar != null) return false;
        if (contactLe != null ? !contactLe.equals(that.contactLe) : that.contactLe != null) return false;
        if (decision != null ? !decision.equals(that.decision) : that.decision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEnseignant;
        result = 31 * result + idOffre;
        result = 31 * result + (contactPar != null ? contactPar.hashCode() : 0);
        result = 31 * result + (contactLe != null ? contactLe.hashCode() : 0);
        result = 31 * result + (decision != null ? decision.hashCode() : 0);
        return result;
    }
}
