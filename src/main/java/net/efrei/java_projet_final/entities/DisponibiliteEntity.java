package net.efrei.java_projet_final.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = DisponibiliteEntity.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = "DisponibiliteEntity.findAll", query = "SELECT d FROM DisponibiliteEntity d"),
        @NamedQuery(name = "DisponibiliteEntity.findByDateDebut", query = "SELECT d FROM DisponibiliteEntity d WHERE d.dateDebut = :dateDebut"),
        @NamedQuery(name = "DisponibiliteEntity.findByDateFin", query = "SELECT d FROM DisponibiliteEntity d WHERE d.dateFin = :dateFin"),
})
public class DisponibiliteEntity implements Serializable {
    public static final String TABLE_NAME = "Disponibilite";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dateDebut")
    private LocalDate dateDebut;

    @Column(name = "dateFin")
    private LocalDate dateFin;

    public Integer getId() {
        return id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "DisponibiliteEntity{" + "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisponibiliteEntity)) return false;
        DisponibiliteEntity that = (DisponibiliteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateDebut, dateFin);
    }
}
