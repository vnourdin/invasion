package IHM.MenuOptions;

import Config.Ressources;
import Config.Variables;
import IHM.Generiques.OptionACocher;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OptionBarre extends OptionACocher {

    public OptionBarre(ActionListener listener) {
        super("Afficher la barre d'aide", listener);

        this.setSelectedIcon(new ImageIcon(Ressources.aideON));
        this.setIcon(new ImageIcon(Ressources.aideOFF));

        this.setToolTipText("Permet d'afficher ou non la barre en dessous de laquelle les mots sont colorés !");

        this.setSelected(Variables.AFFICHER_BARRE_DELIMITATION);
        this.actualiserCouleur();
    }
}