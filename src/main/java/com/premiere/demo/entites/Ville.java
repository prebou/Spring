package com.premiere.demo.entites;

public class Ville {

    private String nom;
    private double nbHabitants;

    public Ville() {
    }

    public Ville(String nom, double nbHabitants) {
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
}
