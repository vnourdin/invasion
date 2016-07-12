package IHM.Generiques;

import Config.Variables;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoutonValider extends Bouton implements MouseListener {

    public BoutonValider(ActionListener listener) {
        super(listener);

        this.setContentAreaFilled(true);

        this.setText("VALIDER");
        this.setPreferredSize(new Dimension(100, 50));

        this.setBackground(Variables.COULEUR_BOUTONS);
        this.setForeground(Variables.COULEUR_FOND);

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