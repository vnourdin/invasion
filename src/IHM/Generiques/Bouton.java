package IHM.Generiques;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Bouton extends JButton {

    protected Bouton(ActionListener listener) {
        super();
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.addActionListener(listener);
        this.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
    }
}
