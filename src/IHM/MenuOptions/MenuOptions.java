package IHM.MenuOptions;

import Config.Constantes;
import Config.Variables;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import IHM.Generiques.OptionACocher;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Concrets.MoteurInvasion;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuOptions extends Menu {

    private OptionACocher choixSon, choixColoration, choixBarre;
    private BoutonTheme boutonTheme;
    private BoutonRetour retour;

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Options");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        this.choixSon = new OptionSon(this);
        this.choixColoration = new OptionCouleur(this);
        this.choixBarre = new OptionBarre(this);
        this.retour = new BoutonRetour(this);
        this.boutonTheme = new BoutonTheme(this);
    }

    @Override
    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.choixSon, contrainte);
        this.contrainte.gridy = 2;
        this.add(this.choixColoration, contrainte);
        this.contrainte.gridy = 3;
        this.add(this.choixBarre, contrainte);
        this.contrainte.gridy = 4;
        this.add(this.boutonTheme, contrainte);

        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.choixSon)
            this.actualiserSon();
        else if (e.getSource() == this.choixColoration)
            this.actualiserColoration();
        else if (e.getSource() == this.choixBarre)
            this.actualiserBarre();
        else if (e.getSource() == this.retour)
            this.precedent();
        else if (e.getSource() == this.boutonTheme)
            this.passerATheme();
        this.requestFocusInWindow();
    }

    private void passerATheme() {
        AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_THEME);
    }

    private void actualiserSon() {
        this.choixSon.actualiserCouleur();
        Variables.SON = this.choixSon.isSelected();
    }

    private void actualiserColoration() {
        this.choixColoration.actualiserCouleur();
        Variables.COLORER_MOT_SELECTIONE = this.choixColoration.isSelected();
    }

    private void actualiserBarre() {
        this.choixBarre.actualiserCouleur();
        Variables.AFFICHER_BARRE_DELIMITATION = this.choixBarre.isSelected();
    }

    private void precedent() {
        if (MoteurInvasion.getInstance().getPartie().enCours)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_PAUSE);
        else
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
    }
}