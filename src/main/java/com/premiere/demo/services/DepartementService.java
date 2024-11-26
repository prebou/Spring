package com.premiere.demo.services;

import com.premiere.demo.dao.DepartementDao;
import com.premiere.demo.entites.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementDao departementDao;

    public List<Departement> extractDepartements() {
        return departementDao.extractDepartements();
    }

    public Departement extractDepartement(int id) {
        Departement departement = departementDao.extractDepartements().stream().findFirst().filter(departement1 -> departement1.getId() == id).orElse(null);
        return departement;
    }

    public List<Departement> insertDepartement(Departement departement) {
        departementDao.createDepartement(departement);
        return departementDao.extractDepartements();
    }

    public List<Departement> modifierDepartement(Departement departementModifiee) {
        departementDao.updateDepartement(departementModifiee);

        return departementDao.extractDepartements();
    }

    public List<Departement> supprimerDepartement(int idDepartement) {
        departementDao.deleteDepartement(idDepartement);
        return departementDao.extractDepartements();
    }

    public Departement extractDepartementParNom(Departement departement) {
        Departement v = extractDepartements().stream().filter(departement1 -> departement1.getNom().equals(departement.getNom())).findFirst().orElse(null);
        return v;
    }

}
