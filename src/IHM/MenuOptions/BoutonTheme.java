package IHM.MenuOptions;

import Config.Ressources;
import IHM.Generiques.OptionACocher;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BoutonTheme extends OptionACocher {

    public BoutonTheme(ActionListener listener) {
        super("Thème", listener);

        this.setSelectedIcon(new ImageIcon(Ressources.peintureON));
        this.setIcon(new ImageIcon(Ressources.peintureON));

        this.setToolTipText("Permet de changer le theme de couleur du jeu !");
    }
}