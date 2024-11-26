package com.premiere.demo.controleurs;

import com.premiere.demo.entites.Departement;
import com.premiere.demo.entites.Ville;
import com.premiere.demo.services.DepartementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/Departements")
public class DepartementControleur {

    @Autowired
    DepartementService departementService;

    Departement departement = new Departement("92","Haut-de-seine",new ArrayList<>(Arrays.asList(new Ville("Colombes",123580))));




    /**
     * Getter
     *
     * @return departementService
     */
    @GetMapping
    public List<Departement> getDepartements(){
        return departementService.extractDepartements();
    }

    @GetMapping(path = "/{id}")
    public Departement getdepartement(@PathVariable int id) {

        //return villeService.trouverParId(id);
        return departementService.extractDepartement(id);
    }

    @PostMapping
    public ResponseEntity<String> insertDepartement(@Valid @RequestBody Departement departement) {
        departementService.insertDepartement(departement);
        return ResponseEntity.ok("Departement insérée avec succès");
    }

    @PutMapping
    public ResponseEntity<String> modifierDepartement(@Valid @RequestBody Departement departementModifie) {

        if (departementService.extractDepartementParNom(departementModifie)!= null) {
            departementService.modifierDepartement(departementModifie);
            return ResponseEntity.ok("Reussi !");
        }

        else {
            return ResponseEntity.badRequest().body("Mise à jour a echouée");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerDepartement(@PathVariable int id) {

        if (departementService.extractDepartement(id) != null) {
            departementService.supprimerDepartement(id);
            return ResponseEntity.ok("Suppression reussi !");
        }

        return ResponseEntity.badRequest().body("La suppresion a échouée");

    }
}
