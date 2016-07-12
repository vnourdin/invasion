package IHM.Jeu;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;
import Moteurs.Generiques.Joueur;

import javax.swing.*;
import java.awt.*;

public class Coeurs extends JPanel {

    public Coeurs() {
        super();
        this.setPreferredSize(new Dimension(Constantes.LARGEUR_COEURS, Ressources.coeur.getHeight()));
        this.setBackground(Variables.COULEUR_BOUTONS_SURVOL);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < Constantes.NB_MAX_VIES; i++) {
            if (Joueur.getInstance().getNbVies() > i)
                g.drawImage(Ressources.coeur, i * (Ressources.coeur.getWidth() + 5), 0, null);
            else
                g.drawImage(Ressources.coeurVide, i * (Ressources.coeur.getWidth() + 5), 0, null);
        }
    }
}