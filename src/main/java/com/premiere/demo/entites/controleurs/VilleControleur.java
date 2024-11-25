package com.premiere.demo.entites.controleurs;

import com.premiere.demo.entites.Ville;
import com.premiere.demo.services.VilleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    //List<Ville> villes = new ArrayList<>();

    @Autowired
    VilleService villeService;


    /**
     * Getter
     *
     * @return villes
     */
    @GetMapping
    public List<Ville> getVilles() {

        return villeService.getListVilles();
    }

    @GetMapping(path = "/{id}")
    public Ville getVille(@PathVariable int id) {

        return villeService.trouverParId(id);
    }


    @PostMapping
    public ResponseEntity<String> insertVilles(@Valid @RequestBody Ville ville) {
        boolean exist = villeService.getListVilles().stream().anyMatch(ville1 -> ville1.getNom().equals(ville.getNom()));

        if (exist) {
            return ResponseEntity.badRequest().body("La ville existe déjà");
        }

        int size = villeService.getListVilles().size();
        ville.setId(size);
        villeService.ajouterVille(ville);
        return ResponseEntity.ok("Ville insérée avec succès");
    }


    @PutMapping
    public ResponseEntity<String> modifierVille(@Valid @RequestBody Ville villeModifie, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Problème de validation des contraintes !");
        }
        if (villeService.miseAJour(villeModifie)) {
            return ResponseEntity.ok("Reussi !");
        }

        else {
            return ResponseEntity.badRequest().body("Mise à jour a echouée");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerVille(@PathVariable int id) {
        if (villeService.supprimer(id)) {
            return ResponseEntity.ok("Suppression reussi !");
        }

        return ResponseEntity.badRequest().body("La suppresion a échouée");

    }


}



