package Moteurs.Concrets;

import Config.Variables;
import Moteurs.Generiques.MoteurDeJeu;
import Moteurs.Generiques.Partie;
import Textes.Ligne;

import java.util.ArrayList;

public class MoteurInvasion extends MoteurDeJeu {

    private static MoteurInvasion moteurInvasion;
    private long tempsDerniereLigne;
    private ArrayList<Ligne> lignes;
    private int compteur;

    public static synchronized MoteurInvasion getInstance() {
        if (moteurInvasion == null) moteurInvasion = new MoteurInvasion();
        return moteurInvasion;
    }

    @Override
    public void initialiser() {
        super.initialiser();
        Variables.PARTIE_CHOISIE = null;
        this.lignes = new ArrayList<>();
        this.tempsDerniereLigne = 0;
        this.compteur = 0;
    }

    public void nouvellePartie(Partie partie) {
        this.initialiser();
        this.partie = partie;
        this.lignes = this.partie.getLignes();
        this.afficheur.nouvellePartie();
    }

    @Override
    protected void actualiser() {
        super.actualiser();
        if (this.temps_debut - this.tempsDerniereLigne > 1000) {
            if (this.compteur < this.lignes.size()) {
                this.lignes.get(this.compteur).ajouterA(this);
                this.compteur++;
                this.tempsDerniereLigne = this.temps_debut;
            }
        }
    }

    public ArrayList<Ligne> getLignes() {
        return this.lignes;
    }
}