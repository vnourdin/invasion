package IHM.Jeu;

import Config.Variables;

import javax.swing.*;
import java.awt.*;

public class ZoneDeSaisie extends JPanel {

    private BarreDeSaisie barreDeSaisie;
    private Score score;
    private Coeurs coeurs;

    public ZoneDeSaisie() {
        super(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);

        this.score = new Score();
        this.coeurs = new Coeurs();
        this.barreDeSaisie = new BarreDeSaisie("Tapez ici");

        this.setPreferredSize(new Dimension(Variables.LARGEUR_DE_LA_FENETRE, Variables.HAUTEUR_DE_LA_ZONE_DE_SAISIE));
        this.setBackground(Variables.COULEUR_BOUTONS_SURVOL);

        this.add(this.score, contrainte);
        contrainte.anchor = GridBagConstraints.CENTER;
        this.add(this.barreDeSaisie, contrainte);
        contrainte.anchor = GridBagConstraints.LINE_END;
        this.add(this.coeurs, contrainte);
    }

    public void donnerFocusALaSaisie() {
        this.barreDeSaisie.requestFocusInWindow();
    }

    public void actualiserScoreEtVies() {
        this.score.actualiserScore();
        this.coeurs.repaint();
    }
}