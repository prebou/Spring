package com.premiere.demo.entites.controleurs;

import com.premiere.demo.entites.Ville;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    List<Ville> villes = new ArrayList<>();
//    @Autowired
//    VilleService villeService;


    /**
     * Getter
     *
     * @return villes
     */
    @GetMapping
    public List<Ville> getVilles() {
        return villes;
    }

    public List<Ville> villeList() {
        Ville paris = new Ville("Paris", 2_087_600);
        Ville colombes = new Ville("Colombes", 88_850);
        Collections.addAll(villes, paris, colombes);
        return villes;
    }

    //@GetMapping
    public Map<String, List> villeDict() {
        Map<String, List> villes = new HashMap<>();
        villes.put("villes", villeList());
        return villes;
    }

    @PostMapping
    public ResponseEntity<String> insertVilles(@RequestBody Ville ville) {
        boolean exist = villes.stream().anyMatch(ville1 -> ville1.getNom().equals(ville.getNom()));

        if (exist){
            return ResponseEntity.badRequest().body("La ville existe déjà");
        }

        villes.add(ville);
        return ResponseEntity.ok("Ville insérée avec succès");
    }
}



