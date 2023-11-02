package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Competence", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"),
        @NamedQuery(name = "Competence.findByCompetence", query = "SELECT c FROM Competence c WHERE c.competence = :competence"),
})
public class Competence {
    @Id
    @Column(name = "competence", nullable = false)
    private String competence;

    @ManyToMany
    @JoinTable(name = "demande",
            joinColumns = @JoinColumn(name = "competence"),
            inverseJoinColumns = @JoinColumn(name = "idOffre"))
    private Set<Offre> offres = new LinkedHashSet<>();

    @OneToMany(mappedBy = "competence")
    private Set<Evalue> evalues = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "possede",
            joinColumns = @JoinColumn(name = "competence"),
            inverseJoinColumns = @JoinColumn(name = "idEnseignant"))
    private Set<Enseignant> enseignants = new LinkedHashSet<>();

    @OneToMany(mappedBy = "competence")
    private Set<RecommandeEnseignant> recommandeEnseignants = new LinkedHashSet<>();

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public Set<Offre> getOffres() {
        return offres;
    }

    public void setOffres(Set<Offre> offres) {
        this.offres = offres;
    }

    public Set<Evalue> getEvalues() {
        return evalues;
    }

    public void setEvalues(Set<Evalue> evalues) {
        this.evalues = evalues;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public Set<RecommandeEnseignant> getRecommandeEnseignants() {
        return recommandeEnseignants;
    }

    public void setRecommandeEnseignants(Set<RecommandeEnseignant> recommandeEnseignants) {
        this.recommandeEnseignants = recommandeEnseignants;
    }

}