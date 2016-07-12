package IHM.MenuAPropos;

import Config.Constantes;
import IHM.Generiques.Bouton;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import Moteurs.Concrets.AfficheurInvasion;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuAPropos extends Menu {

    private Bouton boutonRetour;
    private TexteAPropos texte;

    public MenuAPropos() {
        super();
    }

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("À propos");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        this.boutonRetour = new BoutonRetour(this);
        this.texte = new TexteAPropos();
    }

    @Override
    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.texte, this.contrainte);

        this.contrainte.gridy = 2;
        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.boutonRetour, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.boutonRetour) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
        }
    }
}