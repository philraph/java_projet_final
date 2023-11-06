package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Ecole", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Ecole.findAll", query = "SELECT e FROM Ecole e"),
        @NamedQuery(name = "Ecole.findByRaisonSociale", query = "SELECT e FROM Ecole e WHERE e.raisonSociale = :raisonSociale"),
        @NamedQuery(name = "Ecole.findByUsername", query = "SELECT e FROM Ecole e WHERE e.idUtilisateur.username = :username")
})
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "raisonSociale")
    private String raisonSociale;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUtilisateur", nullable = false)
    private Utilisateur idUtilisateur;

    @OneToMany(mappedBy = "idEcole")
    private Set<Offre> offres = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEcole")
    private Set<Evalue> evalues = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "interesse",
            joinColumns = @JoinColumn(name = "idEcole"),
            inverseJoinColumns = @JoinColumn(name = "idEnseignant"))
    private Set<Enseignant> enseignants = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

}