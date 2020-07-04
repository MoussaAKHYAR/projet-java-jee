package com.aegisi.test;

import com.aegisi.dao.IMembre;
import com.aegisi.dao.MembreImpl;
import com.aegisi.entities.Membre;

public class Test {
    public static void main(String[] args) {
        IMembre membredao = new MembreImpl();
        Membre membre = new Membre();

        membre.setNom("AKHYAR");
        membre.setPrenom("Moussa");
        membre.setClasse("MIAGE");
        membre.setNumero("771381498");

        int ok = membredao.add(membre);
    }
}
