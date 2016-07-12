package Textes;

import java.util.ArrayList;

public class Texte {

    private ArrayList<Ligne> lignes;

    public Texte() {
        this.lignes = new ArrayList<>();
    }

    public void ajouterLigne(Ligne nouvelleLigne) {
        this.lignes.add(nouvelleLigne);
    }

    public ArrayList<Ligne> getLignes() {
        return this.lignes;
    }
}