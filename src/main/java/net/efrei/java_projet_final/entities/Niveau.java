package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Niveau", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n"),
        @NamedQuery(name = "Niveau.findByNiveau", query = "SELECT n FROM Niveau n WHERE n.niveau = :niveau"),
})
public class Niveau {
    @Id
    @Column(name = "niveau", nullable = false)
    private String niveau;

    @ManyToMany
    @JoinTable(name = "souhaite",
            joinColumns = @JoinColumn(name = "niveau"),
            inverseJoinColumns = @JoinColumn(name = "idEnseignant"))
    private Set<Enseignant> enseignants = new LinkedHashSet<>();

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

}