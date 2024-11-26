package com.premiere.demo.dao;

import com.premiere.demo.entites.Departement;
import com.premiere.demo.entites.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartementDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createDepartement(Departement departement) {
        em.persist(departement);
    }

    public List<Departement> extractDepartements() {
        TypedQuery<Departement> query = em.createQuery("Select d From Departement d", Departement.class);
        return query.getResultList();
    }

    @Transactional
    public void updateDepartement(Departement departement) {

        Departement d = extractDepartements().stream().filter(departement1 -> departement1.getNom().equals(departement.getNom())).findFirst().orElse(null);
        d.setNom(departement.getNom());
        em.merge(d);
    }

    @Transactional
    public void deleteDepartement(int id) {
        Departement departement = em.find(Departement.class, id);
        if (departement != null) {
            em.remove(departement);
        }
    }

}
