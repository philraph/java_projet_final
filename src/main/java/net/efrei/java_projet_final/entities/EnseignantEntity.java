package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = EnseignantEntity.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = "EnseignantEntity.findAll", query = "SELECT e FROM EnseignantEntity e"),
        @NamedQuery(name = "EnseignantEntity.findByNom", query = "SELECT e FROM EnseignantEntity e WHERE e.nom = :nom"),
        @NamedQuery(name = "EnseignantEntity.findByPrenom", query = "SELECT e FROM EnseignantEntity e WHERE e.prenom = :prenom"),
        @NamedQuery(name = "EnseignantEntity.findByMail", query = "SELECT e FROM EnseignantEntity e WHERE e.mail = :mail"),
        @NamedQuery(name = "EnseignantEntity.findByTelephone", query = "SELECT e FROM EnseignantEntity e WHERE e.telephone = :telephone"),
        @NamedQuery(name = "EnseignantEntity.findByCentreInterets", query = "SELECT e FROM EnseignantEntity e WHERE e.centreInterets = :centreInterets"),
        @NamedQuery(name = "EnseignantEntity.findBySites", query = "SELECT e FROM EnseignantEntity e WHERE e.sites = :sites"),
        @NamedQuery(name = "EnseignantEntity.findByTypeContrat", query = "SELECT e FROM EnseignantEntity e WHERE e.typeContrat = :typeContrat"),
        @NamedQuery(name = "EnseignantEntity.findByExtra", query = "SELECT e FROM EnseignantEntity e WHERE e.extra = :extra"),
        @NamedQuery(name = "EnseignantEntity.findByUsername", query = "SELECT e FROM EnseignantEntity e WHERE e.utilisateur.username = :username"),
        @NamedQuery(name = "EnseignantEntity.findByUsernameAndStatus", query = "SELECT e FROM EnseignantEntity e WHERE e.utilisateur.username = :username AND e.utilisateur.isAdmin = :isAdmin AND e.utilisateur.isValid = :isValid")
})
public class EnseignantEntity implements Serializable {
    public static final String TABLE_NAME = "Enseignant";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "centreInterets")
    private String centreInterets;

    @Column(name = "sites")
    private String sites;

    @Column(name = "typeContrat", nullable = false)
    private String typeContrat;

    @Column(name = "extra")
    private String extra;

    @OneToOne
    @JoinColumn(name = "idUtilisateur", nullable = false, unique = true)
    private UtilisateurEntity utilisateur;

    @ManyToMany
    @JoinTable(
            name = "dispo",
            joinColumns = @JoinColumn(name = "idEnseignant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idDispo", referencedColumnName = "id")
    )
    private Set<DisponibiliteEntity> disponibilites = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "possede",
            joinColumns = @JoinColumn(name = "idEnseignant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "competence", referencedColumnName = "competence")
    )
    private Set<CompetenceEntity> competences = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "jouit",
            joinColumns = @JoinColumn(name = "idEnseignant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "nomTitre", referencedColumnName = "nomTitre")
    )
    private Set<TitreEntity> titres = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "souhaite",
            joinColumns = @JoinColumn(name = "idEnseignant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "niveau", referencedColumnName = "niveau")
    )
    private Set<NiveauEntity> niveauxSouhaites = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "interesse",
            joinColumns = @JoinColumn(name = "idEnseignant", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idEcole", referencedColumnName = "id")
    )
    private Set<EcoleEntity> ecolesSouhaitees = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getCentreInterets() {
        return centreInterets;
    }

    public String getExtra() {
        return extra;
    }

    public String getMail() {
        return mail;
    }

    public String getSites() {
        return sites;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public Set<DisponibiliteEntity> getDisponibilites() {
        return disponibilites;
    }

    public Set<CompetenceEntity> getCompetences() {
        return competences;
    }

    public Set<TitreEntity> getTitres() {
        return titres;
    }

    public Set<NiveauEntity> getNiveauxSouhaites() {
        return niveauxSouhaites;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setCentreInterets(String centreInterets) {
        this.centreInterets = centreInterets;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Override
    public String toString() {
        return "EnseignantEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", centreInterets='" + centreInterets + '\'' +
                ", sites='" + sites + '\'' +
                ", typeContrat='" + typeContrat + '\'' +
                ", extra='" + extra + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnseignantEntity)) return false;
        EnseignantEntity that = (EnseignantEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(mail, that.mail) && Objects.equals(telephone, that.telephone) && Objects.equals(centreInterets, that.centreInterets) && Objects.equals(sites, that.sites) && Objects.equals(typeContrat, that.typeContrat) && Objects.equals(extra, that.extra) && Objects.equals(utilisateur, that.utilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, mail, telephone, centreInterets, sites, typeContrat, extra, utilisateur);
    }
}
