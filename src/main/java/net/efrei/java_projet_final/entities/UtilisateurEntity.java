package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = UtilisateurEntity.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = "UtilisateurEntity.findAll", query = "SELECT u FROM UtilisateurEntity u"),
        @NamedQuery(name = "UtilisateurEntity.findByUsername", query = "SELECT u FROM UtilisateurEntity u WHERE u.username = :username"),
        @NamedQuery(name = "UtilisateurEntity.findByIsAdmin", query = "SELECT u FROM UtilisateurEntity u WHERE u.isAdmin = :isAdmin"),
        @NamedQuery(name = "UtilisateurEntity.findByIsValid", query = "SELECT u FROM UtilisateurEntity u WHERE u.isValid = :isValid"),
        @NamedQuery(name = "UtilisateurEntity.findByUsernameAndStatus", query = "SELECT u FROM UtilisateurEntity u WHERE u.username = :username AND u.isAdmin = :isAdmin AND u.isValid = :isValid")
})
public class UtilisateurEntity implements Serializable {
    public static final String TABLE_NAME = "Utilisateur";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private Boolean isAdmin;

    @Column(name = "valide")
    private Boolean isValid;

    public Integer getId() {
        return id;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "UtilisateurEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isValid=" + isValid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtilisateurEntity)) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(isAdmin, that.isAdmin) && Objects.equals(isValid, that.isValid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, isAdmin, isValid);
    }
}
