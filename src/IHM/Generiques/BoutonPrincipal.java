package IHM.Generiques;

import Config.Constantes;
import Config.Variables;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class BoutonPrincipal extends Bouton implements MouseListener {

    protected BoutonPrincipal(ActionListener listener) {
        super(listener);

        this.addMouseListener(this);

        this.setMargin(new Insets(5, 10, 5, 10));

        this.setContentAreaFilled(true);
        this.setFocusPainted(false);
        this.setSelected(true);

        this.setPreferredSize(Constantes.TAILLE_BOUTON);
        this.setBackground(Variables.COULEUR_BOUTONS);
        this.setForeground(Variables.COULEUR_FOND);
        this.setMargin(new Insets(5, 10, 5, 10));
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