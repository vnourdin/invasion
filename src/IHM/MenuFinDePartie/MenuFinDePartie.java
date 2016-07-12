package IHM.MenuFinDePartie;

import Config.Constantes;
import IHM.Generiques.BoutonAccueil;
import IHM.Generiques.BoutonQuitter;
import IHM.Generiques.BoutonRejouer;
import IHM.Generiques.Menu;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Concrets.MoteurInvasion;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class MenuFinDePartie extends Menu {

    private JButton boutonAcceuil, boutonQuitter, boutonRejouer;
    private TexteFinDePartie score, texte, meilleurScore;


    protected void preparerLesComposants() {
        this.boutonAcceuil = new BoutonAccueil(this);
        this.boutonQuitter = new BoutonQuitter(this);
        this.boutonRejouer = new BoutonRejouer(this);

        this.score = new TexteFinDePartie();
        this.meilleurScore = new TexteFinDePartie();
        this.texte = new TexteFinDePartie();

        this.addComponentListener(new MenuAdapterFinDePartie(this));
    }

    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.texte, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.score, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.meilleurScore, this.contrainte);
        this.contrainte.gridy = 4;
        this.add(this.boutonRejouer, this.contrainte);
        this.contrainte.gridy = 5;
        this.add(this.boutonAcceuil, this.contrainte);
        this.contrainte.gridy = 6;
        this.add(this.boutonQuitter, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.boutonAcceuil)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
        else if (e.getSource() == this.boutonRejouer)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_LIVRES);
        else if (e.getSource() == this.boutonQuitter) {
            if (JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter ? ", "Quitter ?", JOptionPane.YES_NO_OPTION) == 0)
                MoteurInvasion.getInstance().arreter();
        }
    }

    public void setScore(String score) {
        this.score.setText(score);
    }

    public void setDescription(String desc) {
        this.texte.setText(desc);
    }

    public void setMeilleurScore(String meilleurScore) {
        this.meilleurScore.setText(meilleurScore);
    }
}