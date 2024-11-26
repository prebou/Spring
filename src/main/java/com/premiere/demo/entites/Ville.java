package com.premiere.demo.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ville")
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2)
    private String nom;

    @Min(1)
    private double nbHabitants;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Departement departement;

    {
        departement = new Departement();
    }

    public Ville() {
    }

    public Ville(String nom, double nbHabitants) {
        this.nom = nom;
        this.nbHabitants = nbHabitants;
    }

    public Ville(String nom, double nbHabitants, Departement departement) {
        this.nom = nom;
        this.nbHabitants = nbHabitants;
        this.departement = departement;
    }

    /**
     * Getter
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter
     *
     * @return nbHabitants
     */
    public double getNbHabitants() {
        return nbHabitants;
    }

    /**
     * Setter
     *
     * @param nbHabitants
     */
    public void setNbHabitants(double nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public int getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public Departement getDepartement(){
        return departement;
    }

    public void setDepartement(Departement departement){
        this.departement = departement;
    }
}
