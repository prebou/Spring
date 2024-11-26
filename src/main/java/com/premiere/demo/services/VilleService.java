package com.premiere.demo.services;

import com.premiere.demo.dao.VilleDao;
import com.premiere.demo.entites.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VilleService {

    @Autowired
    private VilleDao villeDao;

    private List<Ville> listVilles;//= new ArrayList<>(Arrays.asList(new Ville("Paris",2133111), new Ville("Marseille", 873076), new Ville("Lyon", 522250)));

    public VilleService() {

    }

    public List<Ville> extractVilles() {
        return villeDao.extractVilles();
    }

    public Ville extractVille(int id) {
        Ville ville = villeDao.extractVilles().stream().findFirst().filter(ville1 -> ville1.getId() == id).orElse(null);
        return ville;
    }

//    private Ville extractVille(String name) {
//        Ville result = this.listVilles.stream().filter(element -> name.equals(element.getNom())).findAny().orElse(null);
//        return result;
//    }

    public List<Ville> insertVille(Ville ville) {
        villeDao.insertVille(ville);
        return villeDao.extractVilles();
    }

    public List<Ville> modifierVille(Ville villeModifiee) {
        villeDao.updateVille(villeModifiee);

        return villeDao.extractVilles();
    }

    public List<Ville> supprimerVille(int idVille) {
        villeDao.deleteVille(idVille);
        return villeDao.extractVilles();
    }

    public Ville extractVilleParNom(Ville ville) {
        Ville v = extractVilles().stream().filter(ville1 -> ville1.getNom().equals(ville.getNom())).findFirst().orElse(null);
        return v;
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
        if (resultat != null) {
            return false;
        }
        this.listVilles.add(ville);
        return true;
    }

    public boolean miseAJour(Ville ville) {
        Ville ville1 = trouverParId(ville.getId());
        if (ville1 != null) {
            ville1.setNom(ville.getNom());
            ville1.setNbHabitants(ville.getNbHabitants());
            return true;
        }
        return false;
    }

    public boolean supprimer(int id) {
        Ville ville = trouverParId(id);
        if (ville != null) {
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
