package IHM.Jeu;

import Config.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Jeu extends JPanel {

    private DessinJeu dessinJeu;

    private BufferedImage imageActuelle;
    private BufferedImage imageSuivante;

    private ZoneDeSaisie zoneDeSaisie;

    public Jeu(DessinJeu dessin) {
        super();
        this.setPreferredSize(new Dimension(Variables.LARGEUR_DE_LA_FENETRE, Variables.HAUTEUR_DE_LA_FENETRE));

        this.dessinJeu = dessin;
        this.imageSuivante = new BufferedImage(Variables.LARGEUR_DE_LA_ZONE_DE_TEXTE, Variables.HAUTEUR_DE_LA_ZONE_DE_TEXTE, BufferedImage.TYPE_INT_ARGB);
        this.imageActuelle = new BufferedImage(Variables.LARGEUR_DE_LA_ZONE_DE_TEXTE, Variables.HAUTEUR_DE_LA_ZONE_DE_TEXTE, BufferedImage.TYPE_INT_ARGB);

        this.setLayout(new BorderLayout());
        this.zoneDeSaisie = new ZoneDeSaisie();
        this.add(this.zoneDeSaisie, BorderLayout.SOUTH);
    }

    public void donnerFocusALaSaisie() {
        this.zoneDeSaisie.donnerFocusALaSaisie();
    }

    public void dessinerLeJeu() {
        this.dessinJeu.dessiner((Graphics2D) this.imageSuivante.getGraphics());

        BufferedImage tmp = this.imageActuelle;
        this.imageActuelle = this.imageSuivante;
        this.imageSuivante = tmp;
        this.imageSuivante.getGraphics().dispose();

        this.repaint();
        this.zoneDeSaisie.actualiserScoreEtVies();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.imageActuelle, 0, 0, null);
    }
}