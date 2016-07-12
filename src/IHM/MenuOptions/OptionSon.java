package IHM.MenuOptions;

import Config.Ressources;
import Config.Variables;
import IHM.Generiques.OptionACocher;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OptionSon extends OptionACocher {

    public OptionSon(ActionListener listener) {
        super("Son", listener);

        this.setSelectedIcon(new ImageIcon(Ressources.sonON));
        this.setIcon(new ImageIcon(Ressources.sonOFF));

        this.setToolTipText("Permet d'activer ou non tous les sons du jeu !");

        this.setSelected(Variables.SON);
        this.actualiserCouleur();
    }
}