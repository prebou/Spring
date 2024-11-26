package com.premiere.demo.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String nom;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ville> villes;


    {
        villes = new ArrayList<>();
    }

    public Departement() {
    }

    public Departement(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public Departement(String code, String nom, List<Ville> villes) {
        this.code = code;
        this.nom = nom;
        this.villes = villes;
    }

    /**
     * Getter
     *
     * @return id
     */
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

    /**
     * Getter
     *
     * @return numero
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return villes
     */
    public List<Ville> getVilles() {
        return villes;
    }

    /**
     * Setter
     *
     * @param villes
     */
    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }
}
