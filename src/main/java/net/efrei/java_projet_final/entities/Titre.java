package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Titre", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Titre.findAll", query = "SELECT t FROM Titre t"),
        @NamedQuery(name = "Titre.findByNomTitre", query = "SELECT t FROM Titre t WHERE t.nomTitre = :nomTitre")
})
public class Titre {
    @Id
    @Column(name = "nomTitre", nullable = false)
    private String nomTitre;

    @ManyToMany
    @JoinTable(name = "jouit",
            joinColumns = @JoinColumn(name = "nomTitre"),
            inverseJoinColumns = @JoinColumn(name = "idEnseignant"))
    private Set<Enseignant> enseignants = new LinkedHashSet<>();

    public String getNomTitre() {
        return nomTitre;
    }

    public void setNomTitre(String nomTitre) {
        this.nomTitre = nomTitre;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

}