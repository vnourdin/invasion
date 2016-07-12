package IHM.Jeu;

import Config.Variables;
import Moteurs.Generiques.Joueur;

import javax.swing.*;

public class Score extends JLabel {

    public Score() {
        super();
        this.setForeground(Variables.COULEUR_FOND);
        this.setFont(Variables.POLICE_BOUTON);
    }

    public void actualiserScore() {
        this.setText("Score : " + Joueur.getInstance().getScore());
    }
}