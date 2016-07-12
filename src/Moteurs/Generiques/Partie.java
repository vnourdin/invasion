package Moteurs.Generiques;

import Config.Variables;
import Textes.Ligne;
import Textes.Texte;

import java.util.ArrayList;

public class Partie {

    public boolean enCours, estEnPause;
    public Texte texte;

    public Partie() {
        this.enCours = false;
        this.estEnPause = true;
    }

    public Partie(Texte texte) {
        this();
        this.texte = texte;
        Variables.TEXTE_DE_LA_PARTIE = texte;
    }

    public ArrayList<Ligne> getLignes() {
        return this.texte.getLignes();
    }
}