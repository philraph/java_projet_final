package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Offre", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Offre.findAll", query = "SELECT o FROM Offre o"),
        @NamedQuery(name = "Offre.findByExigences", query = "SELECT o FROM Offre o WHERE o.exigences = :exigences"),
        @NamedQuery(name = "Offre.findByRemarques", query = "SELECT o FROM Offre o WHERE o.remarques = :remarques"),
        @NamedQuery(name = "Offre.findByEcole", query = "SELECT o FROM Offre o WHERE o.idEcole.raisonSociale = :raisonsociale"),
})
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "exigences")
    private String exigences;

    @Column(name = "remarques")
    private String remarques;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDispo", nullable = false)
    private Disponibilite idDispo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEcole", nullable = false)
    private Ecole idEcole;

    @OneToMany(mappedBy = "idOffre")
    private Set<Candidate> candidates = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "offres")
    private Set<Competence> competences = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExigences() {
        return exigences;
    }

    public void setExigences(String exigences) {
        this.exigences = exigences;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Disponibilite getIdDispo() {
        return idDispo;
    }

    public void setIdDispo(Disponibilite idDispo) {
        this.idDispo = idDispo;
    }

    public Ecole getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(Ecole idEcole) {
        this.idEcole = idEcole;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

}