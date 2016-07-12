package IHM.MenuOptions.MenuTheme;

import Config.Constantes;
import IHM.Generiques.BoutonRadio;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import Moteurs.Concrets.AfficheurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuTheme extends Menu {

    private BoutonRadio clair, sombre;
    private BoutonRetour retour;

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Choix du thème");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        ButtonGroup groupe = new ButtonGroup();
        this.clair = new BoutonThemeClair();
        this.sombre = new BoutonThemeSombre();
        groupe.add(this.clair);
        groupe.add(this.sombre);
        this.retour = new BoutonRetour(this);
    }

    @Override
    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.contrainte.gridy = 1;
        this.add(this.clair, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.sombre, this.contrainte);

        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.retour)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_OPTIONS);
    }
}