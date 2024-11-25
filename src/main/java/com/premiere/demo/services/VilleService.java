package com.premiere.demo.services;

import com.premiere.demo.entites.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VilleService {

    List<Ville> list = new ArrayList<>();
    Ville paris = new Ville("Paris",2_087_600);
    Ville colombes = new Ville("Colombes", 88_850);

    public VilleService(){

    }



}
