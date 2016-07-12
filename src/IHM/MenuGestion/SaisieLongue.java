package IHM.MenuGestion;

import Config.Variables;

import javax.swing.*;
import javax.swing.FocusManager;
import java.awt.*;

public class SaisieLongue extends JTextArea {

    private String description;

    public SaisieLongue(String desc) {
        super();
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        this.setBackground(Variables.COULEUR_BOUTONS);
        this.setForeground(Variables.COULEUR_FOND);
        this.setFont(Variables.POLICE);
        this.setColumns(30);
        this.setLineWrap(true);
        this.setRows(6);
        this.setWrapStyleWord(true);
        this.description = desc;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty() && FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() != this) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setBackground(Color.gray);
            g2d.setFont(Variables.POLICE);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.drawString(this.description, 10, 25);
            g2d.dispose();
        }
    }
}