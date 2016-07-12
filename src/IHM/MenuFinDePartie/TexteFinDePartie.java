package IHM.MenuFinDePartie;

import Config.Variables;

import javax.swing.*;

public class TexteFinDePartie extends JTextArea {

    public TexteFinDePartie() {
        super();
        this.setBackground(Variables.COULEUR_FOND);
        this.setForeground(Variables.COULEUR_TEXTE);
        this.setFont(Variables.POLICE);
    }
}