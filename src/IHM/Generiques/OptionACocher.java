package IHM.Generiques;

import Config.Constantes;
import Config.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OptionACocher extends JCheckBox implements MouseListener {

    public OptionACocher(String nom, ActionListener listener) {
        super(nom);
        this.addActionListener(listener);
        this.addMouseListener(this);

        this.setFocusPainted(false);
        this.setSelected(true);

        this.setPreferredSize(Constantes.TAILLE_BOUTON);
        this.setMargin(new Insets(0, 10, 0, 10));
        this.setBackground(Variables.COULEUR_BOUTONS);
        this.setForeground(Variables.COULEUR_FOND);
        this.setFont(Variables.POLICE_BOUTON);

        this.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
    }

    public void actualiserCouleur() {
        if (this.isSelected())
            this.setForeground(Variables.COULEUR_FOND);
        else
            this.setForeground(Variables.COULEUR_DESACTIVE);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Variables.COULEUR_BOUTONS_SURVOL);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Variables.COULEUR_BOUTONS);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}