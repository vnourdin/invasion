package IHM.Generiques;

import Config.Constantes;
import Config.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class BoutonRadio extends JRadioButton implements MouseListener, ActionListener {

    public BoutonRadio(String nom) {
        super(nom);
        this.addMouseListener(this);
        this.addActionListener(this);

        this.setFocusPainted(false);

        this.setPreferredSize(Constantes.TAILLE_BOUTON);
        this.setMargin(new Insets(0, 10, 0, 10));
        this.setFont(Variables.POLICE_BOUTON);

        this.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
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