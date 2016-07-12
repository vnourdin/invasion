package IHM.Jeu;

import Config.Constantes;
import Config.Variables;
import Listeners.ListenerBarreSaisie;

import javax.swing.*;
import java.awt.*;

public class BarreDeSaisie extends JTextField {

    private String description;

    public BarreDeSaisie(String desc) {
        super();
        this.setPreferredSize(new Dimension(Variables.LARGEUR_DE_LA_FENETRE - (3 * Constantes.LARGEUR_COEURS), Variables.HAUTEUR_DE_LA_ZONE_DE_SAISIE / 2));
        this.addKeyListener(new ListenerBarreSaisie());

        this.setFont(Variables.POLICE);

        this.description = desc;
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setFont(Variables.POLICE);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.drawString(this.description, 5, 20);
            g2d.dispose();
        }
    }
}