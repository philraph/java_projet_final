package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Disponibilite", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Disponibilite.findAll", query = "SELECT d FROM Disponibilite d"),
        @NamedQuery(name = "Disponibilite.findByDateDebut", query = "SELECT d FROM Disponibilite d WHERE d.dateDebut = :dateDebut"),
        @NamedQuery(name = "Disponibilite.findByDateFin", query = "SELECT d FROM Disponibilite d WHERE d.dateFin = :dateFin"),
})
public class Disponibilite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dateDebut")
    private LocalDate dateDebut;

    @Column(name = "dateFin")
    private LocalDate dateFin;

    @OneToMany(mappedBy = "idDispo")
    private Set<Offre> offres = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "dispo",
            joinColumns = @JoinColumn(name = "idDispo"),
            inverseJoinColumns = @JoinColumn(name = "idEnseignant"))
    private Set<Enseignant> enseignants = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Set<Offre> getOffres() {
        return offres;
    }

    public void setOffres(Set<Offre> offres) {
        this.offres = offres;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

}