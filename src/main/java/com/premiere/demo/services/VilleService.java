package com.premiere.demo.services;

import com.premiere.demo.entites.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class VilleService {

   List<Ville> listVilles = new ArrayList<>(Arrays.asList(new Ville("Paris",2133111), new Ville("Marseille", 873076), new Ville("Lyon", 522250)));
//    Ville paris = new Ville("Paris",2_087_600);
//    Ville colombes = new Ville("Colombes", 88_850);

    public VilleService(){

    }

    /**
     * Getter
     *
     * @return listVilles
     */
    public List<Ville> getListVilles() {
        return listVilles;
    }

    public boolean ajouterVille(Ville ville) {
        Ville resultat = trouverParNom(ville.getNom());
        if (resultat != null){
            return false;
        }
        this.listVilles.add(ville);
        return true;
    }

    public boolean miseAJour(Ville ville){
        Ville ville1 = trouverParId(ville.getId());
        if (ville1 != null){
            ville1.setNom(ville.getNom());
            ville1.setNbHabitants(ville.getNbHabitants());
            return true;
        }
        return false;
    }

    public boolean supprimer(int id){
        Ville ville = trouverParId(id);
        if (ville != null){
            listVilles.remove(ville);
            return true;
        }
        return false;
    }

    public Ville trouverParId(int id) {
        Ville result = this.listVilles.stream().filter(ville -> ville.getId() == id).findAny().orElse(null);
        return result;
    }

    private Ville trouverParNom(String name) {
        Ville result = this.listVilles.stream().filter(element -> name.equals(element.getNom())).findAny().orElse(null);
        return result;
    }
}
