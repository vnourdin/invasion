package IHM.MenuOptions;

import Config.Ressources;
import Config.Variables;
import IHM.Generiques.OptionACocher;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OptionCouleur extends OptionACocher {

    public OptionCouleur(ActionListener listener) {
        super("Colorier les mots tapés", listener);

        this.setSelectedIcon(new ImageIcon(Ressources.peintureON));
        this.setIcon(new ImageIcon(Ressources.peintureOFF));

        this.setToolTipText("Permet d'activer ou non la coloration des mots lorsqu'ils sont tapés !");

        this.setSelected(Variables.COLORER_MOT_SELECTIONE);
        this.actualiserCouleur();
    }
}