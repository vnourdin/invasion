package IHM.MenuGestion;

import Config.Constantes;
import Config.Variables;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ListeDeroulante extends JComboBox<String> {

    public ListeDeroulante(ActionListener listener) {
        super();
        this.addActionListener(listener);
        this.setBackground(Variables.COULEUR_BOUTONS);
        this.setForeground(Variables.COULEUR_FOND);
        this.setPreferredSize(Constantes.TAILLE_BOUTON);
        this.setFont(Variables.POLICE_BOUTON);
        this.setMaximumRowCount(4);
        this.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
    }
}