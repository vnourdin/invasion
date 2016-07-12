package Moteurs.Generiques;

import Config.Constantes;
import Config.Variables;
import IHM.Generiques.Contenu;
import IHM.Jeu.DessinJeu;
import IHM.Jeu.Jeu;
import IHM.MenuAPropos.MenuAPropos;
import IHM.MenuChoixFautes.MenuChoixFautes;
import IHM.MenuChoixTexte.MenuChoixTexte;
import IHM.MenuDemarrer.MenuDemarrer;
import IHM.MenuFinDePartie.MenuDefaite;
import IHM.MenuFinDePartie.MenuVictoire;
import IHM.MenuGestion.MenuEcrire.MenuEcrire;
import IHM.MenuGestion.MenuGestion;
import IHM.MenuGestion.MenuImporter.MenuImporter;
import IHM.MenuGestion.MenuSupprimer.MenuSuppression;
import IHM.MenuOptions.MenuOptions;
import IHM.MenuOptions.MenuTheme.MenuTheme;
import IHM.MenuPause.MenuPause;
import Moteurs.Concrets.MoteurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;

public abstract class Afficheur extends JFrame {

    private JPanel panelContenu;
    private Jeu jeu;
    private CardLayout etats;

    protected Afficheur() {
        super(Constantes.NOM_DU_JEU);
        MoteurInvasion.getInstance().associerAfficheur(this);

        this.initialiser();

        this.pack();
        this.createBufferStrategy(2);
        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(Variables.X_DE_LA_FENETRE, Variables.Y_DE_LA_FENETRE);
        this.afficherEtat(Constantes.ID_MENU_DEMARRAGE);
        this.setVisible(true);
    }

    public void initialiser() {
        this.etats = new CardLayout();
        this.panelContenu = new Contenu(this.etats);

        this.jeu = new Jeu(new DessinJeu());
        this.ajouterEtat(this.jeu, Constantes.ID_JEU);
        this.ajouterEtat(new MenuDemarrer(), Constantes.ID_MENU_DEMARRAGE);
        this.ajouterEtat(new MenuChoixFautes(), Constantes.ID_MENU_FAUTES);
        this.ajouterEtat(new MenuChoixTexte(), Constantes.ID_MENU_LIVRES);
        this.ajouterEtat(new MenuPause(), Constantes.ID_MENU_PAUSE);
        this.ajouterEtat(new MenuOptions(), Constantes.ID_MENU_OPTIONS);
        this.ajouterEtat(new MenuTheme(), Constantes.ID_MENU_THEME);
        this.ajouterEtat(new MenuEcrire(), Constantes.ID_MENU_ECRIRE);
        this.ajouterEtat(new MenuDefaite(), Constantes.ID_MENU_DEFAITE);
        this.ajouterEtat(new MenuVictoire(), Constantes.ID_MENU_VICTOIRE);
        this.ajouterEtat(new MenuGestion(), Constantes.ID_MENU_GESTION);
        this.ajouterEtat(new MenuImporter(), Constantes.ID_MENU_IMPORTER);
        this.ajouterEtat(new MenuAPropos(), Constantes.ID_MENU_A_PROPOS);
        this.ajouterEtat(new MenuSuppression(), Constantes.ID_MENU_SUPPRIMER_TEXTE);
        this.setContentPane(this.panelContenu);
    }

    public FontRenderContext getFontRenderContext() {
        return ((Graphics2D) this.getBufferStrategy().getDrawGraphics()).getFontRenderContext();
    }

    public void ajouterEtat(JPanel panel, String id) {
        this.panelContenu.add(panel, id);
    }

    public void afficherEtat(String id) {
        this.etats.show(this.panelContenu, id);
        if (id.equals(Constantes.ID_JEU))
            this.jeu.donnerFocusALaSaisie();
    }

    public void afficher() {
        this.jeu.dessinerLeJeu();
    }

    public void nouvellePartie() {
        Variables.PARTIE_CHOISIE = null;
        this.jeu = new Jeu(new DessinJeu());
        this.ajouterEtat(this.jeu, Constantes.ID_JEU);
    }
}