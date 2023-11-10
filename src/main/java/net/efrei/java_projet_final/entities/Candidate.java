package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "candidate", schema = "projet")
@NamedQueries(
        {
                @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c"),
                @NamedQuery(name = "Candidate.findByEnseignant", query = "SELECT c FROM Candidate c WHERE c.idEnseignant = :enseignant"),
                @NamedQuery(name = "Candidate.findByOffre", query = "SELECT c FROM Candidate c WHERE c.idOffre = :offre"),
                @NamedQuery(name = "Candidate.findByContactPar", query = "SELECT c FROM Candidate c WHERE c.contactPar = :contactPar"),
                @NamedQuery(name = "Candidate.findByContactLe", query = "SELECT c FROM Candidate c WHERE c.contactLe = :contactLe"),
                @NamedQuery(name = "Candidate.findByDecision", query = "SELECT c FROM Candidate c WHERE c.decision = :decision"),
                @NamedQuery(name = "Candidate.findByEcole", query = "SELECT c FROM Candidate c WHERE c.idOffre.idEcole = :ecole")
        }
)
public class Candidate {
    @EmbeddedId
    private CandidateId id;

    @MapsId("idEnseignant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEnseignant", nullable = false)
    private Enseignant idEnseignant;

    @MapsId("idOffre")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idOffre", nullable = false)
    private Offre idOffre;

    @Column(name = "contactPar")
    private String contactPar;

    @Column(name = "contactLe")
    private String contactLe;

    @Column(name = "decision")
    private String decision;

    public CandidateId getId() {
        return id;
    }

    public void setId(CandidateId id) {
        this.id = id;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Offre getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(Offre idOffre) {
        this.idOffre = idOffre;
    }

    public String getContactPar() {
        return contactPar;
    }

    public void setContactPar(String contactPar) {
        this.contactPar = contactPar;
    }

    public String getContactLe() {
        return contactLe;
    }

    public void setContactLe(String contactLe) {
        this.contactLe = contactLe;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

}