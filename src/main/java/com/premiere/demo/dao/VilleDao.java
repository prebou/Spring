package com.premiere.demo.dao;

import com.premiere.demo.entites.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VilleDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insertVille(Ville ville) {
        em.persist(ville);
    }

    public List<Ville> extractVilles() {
        TypedQuery<Ville> query = em.createQuery("Select v From Ville v", Ville.class);
        return query.getResultList();
    }

    @Transactional
    public void updateVille(Ville ville) {

        Ville v = extractVilles().stream().filter(ville1 -> ville1.getNom().equals(ville.getNom())).findFirst().orElse(null);
        v.setNbHabitants(ville.getNbHabitants());
        em.merge(v);
    }

    @Transactional
    public void deleteVille(int id) {
        Ville ville = em.find(Ville.class, id);
        if (ville != null) {
            em.remove(ville);
        }
    }


}
