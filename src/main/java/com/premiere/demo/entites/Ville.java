package com.premiere.demo.entites;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class Ville {

    private static int Compteur_Id = 1;
    private int id;

    @NotNull
    @Size(min = 2)
    private String nom;

    @Min(1)
    private double nbHabitants;

    public Ville() {
    }

    public Ville(String nom, double nbHabitants) {
        this.id = Compteur_Id++ ;
        this.nom = nom;
        this.nbHabitants = nbHabitants;
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
}
