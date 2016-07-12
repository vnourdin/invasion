package IHM.MenuGestion;

import Config.Constantes;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import Moteurs.Concrets.AfficheurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuGestion extends Menu {

    private JButton impoter, ecrire, retour, suppression;

    protected void ajouterEntete() {
        Entete entete = new Entete("Gestion des textes");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        this.impoter = new BoutonImporter(this);
        this.ecrire = new BoutonEcrire(this);
        this.retour = new BoutonRetour(this);
        this.suppression = new BoutonSupprimer(this);
    }

    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.impoter, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.ecrire, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.suppression, this.contrainte);

        this.contrainte.gridy = 4;
        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ecrire) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_ECRIRE);
        } else if (e.getSource() == this.impoter) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_IMPORTER);
        } else if (e.getSource() == this.retour) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
        } else if (e.getSource() == this.suppression) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_SUPPRIMER_TEXTE);
        }
    }
}