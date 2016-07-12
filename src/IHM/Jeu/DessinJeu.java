package IHM.Jeu;

import Config.Variables;
import Moteurs.Concrets.MoteurInvasion;
import Moteurs.Generiques.Dessinable;
import Moteurs.Generiques.MoteurDeJeu;

import java.awt.*;

public class DessinJeu implements Dessinable {

    private MoteurDeJeu moteur;

    public DessinJeu() {
        this.moteur = MoteurInvasion.getInstance();
    }

    @Override
    public void dessiner(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        this.dessinerFond(g2d);
        this.dessinerBarres(g2d);
        this.dessinerDessinables(g2d);
    }

    private void dessinerFond(Graphics2D g2d) {
        g2d.setColor(Variables.COULEUR_FOND);
        g2d.fillRect(0, 0, Variables.LARGEUR_DE_LA_ZONE_DE_TEXTE, Variables.HAUTEUR_DE_LA_ZONE_DE_TEXTE);
    }

    private void dessinerBarres(Graphics2D g2d) {
        if (Variables.AFFICHER_BARRE_DELIMITATION) {
            g2d.setColor(Variables.COULEUR_BARRE);
            g2d.fillRect(0, Variables.HAUTEUR_DE_LA_BARRE_AIDE, Variables.LARGEUR_DE_LA_ZONE_DE_TEXTE, 1);
        }
        g2d.setColor(Variables.COULEUR_BARRE_FIN);
        g2d.fillRect(0, Variables.HAUTEUR_DE_LA_BARRE_FIN, Variables.LARGEUR_DE_LA_ZONE_DE_TEXTE, 1);
    }

    private void dessinerDessinables(Graphics2D g2d) {
        g2d.setFont(Variables.POLICE);
        for (Dessinable d : this.moteur.getDessinables())
            d.dessiner(g2d);
    }
}