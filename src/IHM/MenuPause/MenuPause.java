package IHM.MenuPause;

import Config.Constantes;
import IHM.Generiques.*;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Concrets.MoteurInvasion;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuPause extends Menu {

    private Bouton boutonOptions, boutonReprendre, boutonAccueil, boutonQuitter;

    public MenuPause() {
        super();
    }

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Pause");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        this.boutonReprendre = new BoutonReprendre(this);
        this.boutonOptions = new BoutonOptions(this);
        this.boutonAccueil = new BoutonAccueil(this);
        this.boutonQuitter = new BoutonQuitter(this);
    }

    @Override
    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.boutonReprendre, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.boutonAccueil, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.boutonOptions, this.contrainte);
        this.contrainte.gridy = 4;
        this.add(this.boutonQuitter, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.boutonReprendre) {
            MoteurInvasion.getInstance().getPartie().estEnPause = false;
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_JEU);
        } else if (e.getSource() == this.boutonOptions)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_OPTIONS);
        else if (e.getSource() == this.boutonAccueil) {
            MoteurInvasion.getInstance().getPartie().enCours = false;
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
        } else if (e.getSource() == this.boutonQuitter) {
            if (JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter ? ", "Quitter ?", JOptionPane.YES_NO_OPTION) == 0)
                MoteurInvasion.getInstance().arreter();
        }
    }
}