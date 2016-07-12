package IHM.Generiques;

import Config.Variables;

import javax.swing.*;
import java.awt.*;

public class Entete extends JPanel {

    public Entete(String nom) {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Variables.LARGEUR_DE_LA_FENETRE, Variables.HAUTEUR_DE_LA_FENETRE / 3));
        this.setBackground(Variables.COULEUR_BOUTONS);

        JLabel texte = new JLabel();
        texte.setText(nom);
        texte.setFont(Variables.POLICE_ENTETE);
        texte.setForeground(Variables.COULEUR_FOND);
        texte.setVerticalAlignment(JLabel.CENTER);
        texte.setHorizontalAlignment(JLabel.CENTER);
        this.add(texte, BorderLayout.CENTER);
    }
}