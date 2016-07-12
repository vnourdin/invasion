package IHM.MenuGestion;

import Config.Constantes;
import Config.Variables;
import IHM.Generiques.Bouton;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoutonSupprimer extends Bouton implements MouseListener {

    public BoutonSupprimer(ActionListener listener) {
        super(listener);

        this.setContentAreaFilled(true);

        this.setText("Supprimer");
        this.setFont(Variables.POLICE_ENTETE);
        this.setPreferredSize(Constantes.TAILLE_BOUTON);
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