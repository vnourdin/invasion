package IHM.MenuAPropos;

import Config.Variables;
import IHM.Generiques.Bouton;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoutonAPropos extends Bouton implements MouseListener {

    public BoutonAPropos(ActionListener listener) {
        super(listener);
        this.setContentAreaFilled(true);

        this.setText("À PROPOS");
        this.setBackground(Variables.COULEUR_BOUTONS);
        this.setForeground(Variables.COULEUR_FOND);
        this.setPreferredSize(new Dimension(120, 50));
        this.addMouseListener(this);
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