package com.premiere.demo.controleurs;

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

        //return villeService.getListVilles();
        return villeService.extractVilles();
    }

    @GetMapping(path = "/{id}")
    public Ville getVille(@PathVariable int id) {

        //return villeService.trouverParId(id);
        return villeService.extractVille(id);
    }


    @PostMapping
    public ResponseEntity<String> insertVilles(@Valid @RequestBody Ville ville) {
        villeService.insertVille(ville);

        return ResponseEntity.ok("Ville insérée avec succès");
    }


    @PutMapping
    public ResponseEntity<String> modifierVille(@Valid @RequestBody Ville villeModifie) {


        //Optional<Ville> existe = villeService.extractVilles().stream().filter(ville -> ville.getNom().equals(villeModifie.getNom())).findFirst();


        if (villeService.extractVilleParNom(villeModifie)!= null) {
            villeService.modifierVille(villeModifie);
            return ResponseEntity.ok("Reussi !");
        }

        else {
            return ResponseEntity.badRequest().body("Mise à jour a echouée");
        }



    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerVille(@PathVariable int id) {

        if (villeService.extractVille(id) != null) {
            villeService.supprimerVille(id);
            return ResponseEntity.ok("Suppression reussi !");
        }

        return ResponseEntity.badRequest().body("La suppresion a échouée");

    }


}



