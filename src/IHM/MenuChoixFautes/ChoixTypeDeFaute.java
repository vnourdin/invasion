package IHM.MenuChoixFautes;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;
import IHM.Generiques.OptionACocher;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class ChoixTypeDeFaute extends OptionACocher {

    protected ChoixTypeDeFaute(String nom, ActionListener listener) {
        super(nom, listener);

        this.setBackground(Variables.COULEUR_BOUTONS);
        this.setForeground(Variables.COULEUR_FOND);

        if (Variables.THEME.equals(Constantes.THEME_CLAIR)) {
            this.setIcon(new ImageIcon(Ressources.choixOFF));
            this.setSelectedIcon(new ImageIcon(Ressources.choixON));
        } else if (Variables.THEME.equals(Constantes.THEME_SOMBRE)) {
            this.setIcon(new ImageIcon(Ressources.choixOFF_Sombre));
            this.setSelectedIcon(new ImageIcon(Ressources.choixON_Sombre));
        }
    }
}