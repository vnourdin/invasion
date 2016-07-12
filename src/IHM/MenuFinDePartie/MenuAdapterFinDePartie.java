package IHM.MenuFinDePartie;

import Config.Variables;
import IHM.Generiques.MenuAdapter;
import Moteurs.Concrets.MoteurInvasion;
import Moteurs.Generiques.Joueur;

import java.awt.event.ComponentEvent;

public class MenuAdapterFinDePartie extends MenuAdapter {

    public MenuAdapterFinDePartie(MenuFinDePartie menu) {
        super(menu);
    }

    @Override
    public void componentShown(ComponentEvent e) {
        Joueur.getInstance().actualiserScores();
        ((MenuFinDePartie) this.menu).setScore("Score : " + String.valueOf(Joueur.getInstance().getScore()));
        ((MenuFinDePartie) this.menu).setMeilleurScore("Meilleur score : " + Joueur.getInstance().getMeilleurScore());
        String texte = "Texte : " + Variables.TEXTE_CHOISI + ", " + Variables.CHAPITRE_CHOISI;
        if (Variables.PARTIE_CHOISIE != null)
            texte += ", " + Variables.PARTIE_CHOISIE;
        ((MenuFinDePartie) this.menu).setDescription(texte);
        MoteurInvasion.getInstance().getPartie().enCours = false;
        MoteurInvasion.getInstance().initialiser();
    }
}