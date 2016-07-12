package IHM.Generiques;

import Config.Variables;

import javax.swing.*;
import java.awt.*;

public class Contenu extends JPanel {

    public Contenu(CardLayout layout) {
        super();
        this.setPreferredSize(new Dimension(Variables.LARGEUR_DE_LA_FENETRE, Variables.HAUTEUR_DE_LA_FENETRE));
        this.setLayout(layout);
    }
}