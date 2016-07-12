package IHM.MenuDemarrer;

import Config.Constantes;
import IHM.Generiques.*;
import IHM.Generiques.Menu;
import IHM.MenuAPropos.BoutonAPropos;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Concrets.MoteurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuDemarrer extends Menu {
    private JButton boutonJouer, boutonOptions, boutonAjouterTexte, boutonQuitter, boutonAPropos;

    protected void ajouterEntete() {
        Entete entete = new Entete("L'invasion des fautes d'orthographe");
        this.add(entete, this.contrainte);
    }

    protected void preparerLesComposants() {
        this.boutonJouer = new BoutonJouer(this);
        this.boutonAjouterTexte = new BoutonAjouterTexte(this);
        this.boutonOptions = new BoutonOptions(this);
        this.boutonQuitter = new BoutonQuitter(this);
        this.boutonAPropos = new BoutonAPropos(this);
    }

    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.boutonJouer, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.boutonAjouterTexte, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.boutonOptions, this.contrainte);
        this.contrainte.gridy = 4;
        this.add(this.boutonQuitter, this.contrainte);

        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.boutonAPropos, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.boutonJouer)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_FAUTES);
        else if (e.getSource() == this.boutonAjouterTexte) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_GESTION);
        } else if (e.getSource() == this.boutonOptions)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_OPTIONS);
        else if (e.getSource() == this.boutonQuitter) {
            if (JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter ? ", "Quitter ?", JOptionPane.YES_NO_OPTION) == 0)
                MoteurInvasion.getInstance().arreter();
        } else if (e.getSource() == this.boutonAPropos) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_A_PROPOS);
        }
    }
}