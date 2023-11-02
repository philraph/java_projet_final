package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Utilisateur", schema = "projet")
@NamedQueries({
        @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
        @NamedQuery(name = "Utilisateur.findByUsername", query = "SELECT u FROM Utilisateur u WHERE u.username = :username"),
        @NamedQuery(name = "Utilisateur.findByIsAdmin", query = "SELECT u FROM Utilisateur u WHERE u.isAdmin = :isAdmin"),
        @NamedQuery(name = "Utilisateur.findByIsValid", query = "SELECT u FROM Utilisateur u WHERE u.isValid = :isValid"),
        @NamedQuery(name = "Utilisateur.findByUsernameAndStatus", query = "SELECT u FROM Utilisateur u WHERE u.username = :username AND u.isAdmin = :isAdmin AND u.isValid = :isValid")
})
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @Column(name = "isValid")
    private Boolean isValid;

    @OneToOne(mappedBy = "idUtilisateur")
    private Ecole ecole;

    @OneToOne(mappedBy = "idUtilisateur")
    private Enseignant enseignant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

}