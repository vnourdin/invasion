package Listeners;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Concrets.MoteurInvasion;
import Moteurs.Generiques.Joueur;
import Textes.Ligne;
import Textes.Mot;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ListenerBarreSaisie implements KeyListener {

    private ArrayList<Mot> mots;
    private MoteurInvasion moteur;
    private Mot motATester;
    private String chaineSaisie;
    private Joueur joueur;

    @Override
    public void keyPressed(KeyEvent touche) {
        if (this.moteur == null)
            this.initialiser();

        JTextField barreSaisie = (JTextField) touche.getSource();
        switch (touche.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (this.chaineSaisie != null) {
                    this.chaineSaisie = this.chaineSaisie.substring(0, this.chaineSaisie.length());
                    if (this.chaineSaisie.equals(this.motATester.getOrthographeCorrecte())) {
                        if (!this.motATester.estJuste()) {
                            this.motATester.changerOrthographe(this.chaineSaisie);
                            if (motATester.getY() < Variables.HAUTEUR_DE_LA_BARRE_AIDE)
                                this.joueur.gagnerPoints(chaineSaisie.length() * 150);
                            else
                                this.joueur.gagnerPoints(chaineSaisie.length() * 100);
                            if (Variables.SON) {
                                Ressources.bip.play();
                            }
                            joueur.incrementerNbCorrectionsDeSuite();
                            if (joueur.getNbCorrectionsDeSuite() % 10 == 0)
                                this.joueur.gagnerUneVie();

                            if (joueur.getNbCorrectionsDeSuite() % 5 == 0)
                                Constantes.DEPLACEMENT_LIGNE_MIN += 0.05;
                        }
                    } else {
                        if (Variables.SON) {
                            Ressources.erreur.play();
                        }
                        joueur.reinitialiserNbCorrectionsDeSuite();
                        joueur.perdrePoints(300);
                    }
                    barreSaisie.setText("");
                }
                this.mots.forEach(Mot::deselectionner);
                break;
            case KeyEvent.VK_CAPS_LOCK:
                break;
            case KeyEvent.VK_SHIFT:
                break;
            case KeyEvent.VK_ESCAPE:
                this.moteur.getPartie().estEnPause = true;
                AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_PAUSE);
                break;
            case KeyEvent.VK_DOWN:
                if (Constantes.MODE_DEBUG)
                    Variables.DEPLACEMENT_LIGNE_ACTU += 0.15;
                break;
            case KeyEvent.VK_UP:
                if (Constantes.MODE_DEBUG) {
                    if (Constantes.DEPLACEMENT_LIGNE_MIN <= Variables.DEPLACEMENT_LIGNE_ACTU - 0.15)
                        Variables.DEPLACEMENT_LIGNE_ACTU -= 0.15;
                    else
                        Variables.DEPLACEMENT_LIGNE_ACTU = Constantes.DEPLACEMENT_LIGNE_MIN;
                }
                break;
            default:
                this.chaineSaisie = barreSaisie.getText() + touche.getKeyChar();
                if (touche.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (this.chaineSaisie.length() > 1)
                        this.chaineSaisie = this.chaineSaisie.substring(0, this.chaineSaisie.length() - 2);
                    else {
                        this.chaineSaisie = "";
                        if (this.motATester != null)
                            this.motATester.deselectionner();
                    }
                }
                if (this.chaineSaisie.length() > 0) {
                    boolean trouve = false;
                    for (int i = 0; i < this.mots.size() && !trouve; i++) {
                        if (!this.mots.get(i).estDetruit()) {
                            this.motATester = this.mots.get(i);

                            if (motATester.estSelectionne() && !motATester.getOrthographeCorrecte().startsWith(this.chaineSaisie))
                                this.motATester.deselectionner();

                            if (this.motATester.getOrthographeCorrecte().startsWith(this.chaineSaisie) && !this.motATester.estJuste()) {
                                this.motATester.selectionner();
                                trouve = true;
                            }
                        }
                    }
                } else {
                    if (this.motATester != null)
                        this.motATester.deselectionner();
                }
                break;
        }
    }

    private void initialiser() {
        this.moteur = MoteurInvasion.getInstance();
        this.mots = new ArrayList<>();
        this.joueur = Joueur.getInstance();
        for (Ligne ligne : this.moteur.getLignes()) {
            for (int i = 0; i < ligne.getNbMots(); i++)
                this.mots.add(ligne.getMot(i));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}