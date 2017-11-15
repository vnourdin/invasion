package IHM.MenuChoixTexte;

import Config.Constantes;
import Config.Variables;
import Fabriques.Fautes.FabriqueTexteAFautes;
import Fabriques.Textes.FabriqueTexteDepuisFichier;
import Fabriques.Textes.FabriqueTexteDepuisTxt;
import IHM.Generiques.BoutonJouer;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Concrets.MoteurInvasion;
import Moteurs.Generiques.Partie;
import Textes.Texte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Arrays;

public class MenuChoixTexte extends Menu {

    private ListeDeroulante listeLivres, listeChapitres, listeParties;
    private JButton retour, boutonJouer;

    protected void ajouterEntete() {
        Entete entete = new Entete("Choix du texte");
        this.add(entete, this.contrainte);
    }

    protected void preparerLesComposants() {
        this.listeLivres = new ListeDeroulante(this);
        this.listeChapitres = new ListeDeroulante(this);
        this.listeParties = new ListeDeroulante(this);
        this.boutonJouer = new BoutonJouer(this);
        this.retour = new BoutonRetour(this);

        this.addComponentListener(new MenuAdapterChoixTexte(this));
    }

    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.listeLivres, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.listeChapitres, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.listeParties, this.contrainte);
        this.contrainte.gridy = 4;
        this.add(this.boutonJouer, this.contrainte);

        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.boutonJouer)
            this.lancerPartie();
        else if (e.getSource() == this.listeLivres)
            this.actualiserListeChapitres();
        else if (e.getSource() == this.listeChapitres)
            this.actualiserListeParties();
        else if (e.getSource() == this.retour)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_FAUTES);

        this.requestFocusInWindow();
    }

    private void lancerPartie() {
        FabriqueTexteDepuisFichier fabriqueTDF = new FabriqueTexteDepuisTxt();
        Variables.TEXTE_CHOISI = this.listeLivres.getSelectedItem().toString();
        Variables.CHAPITRE_CHOISI = this.listeChapitres.getSelectedItem().toString();
        String cheminVersTexte = Constantes.CHEMIN_TEXTES
                + "/" + Variables.TEXTE_CHOISI
                + "/" + Variables.CHAPITRE_CHOISI;
        if (this.listeParties.isEnabled()) {
            Variables.PARTIE_CHOISIE = this.listeParties.getSelectedItem().toString();
            cheminVersTexte += "/" + Variables.PARTIE_CHOISIE;
        }
        fabriqueTDF.setCheminVersFichier(cheminVersTexte);
        Texte texte = fabriqueTDF.creerTexte();

        FabriqueTexteAFautes fabriqueTAF = new FabriqueTexteAFautes();
        fabriqueTAF.setTexteAFalsifier(texte);
        Texte texteFaux = fabriqueTAF.creerTexte();

        MoteurInvasion.getInstance().nouvellePartie(new Partie(texteFaux));
        MoteurInvasion.getInstance().lancerPartie();
    }

    public void actualiserListeLivres() {
        this.listeLivres.removeAllItems();
        File[] dossiersLivres = new File(Constantes.CHEMIN_TEXTES).listFiles();
        if (dossiersLivres != null) {
            Arrays.sort(dossiersLivres);
            for (File dossierLivre : dossiersLivres) {
                if (dossierLivre.isDirectory()) {
                    this.listeLivres.addItem(dossierLivre.getName());
                }
            }
        }
    }

    private void actualiserListeChapitres() {
        this.listeChapitres.removeAllItems();

        File[] dossiersChapitres = new File(Constantes.CHEMIN_TEXTES
                + "/" + this.listeLivres.getSelectedItem()).listFiles();

        if (dossiersChapitres != null) {
            this.listeChapitres.setEnabled(true);
            Arrays.sort(dossiersChapitres);
            for (File dossiersChapitre : dossiersChapitres) {
                this.listeChapitres.addItem(dossiersChapitre.getName());
            }
        } else {
            this.listeChapitres.setEnabled(false);
        }
    }

    private void actualiserListeParties() {
        this.listeParties.removeAllItems();

        File[] fichiersParties = new File(Constantes.CHEMIN_TEXTES
                + "/" + this.listeLivres.getSelectedItem()
                + "/" + this.listeChapitres.getSelectedItem()).listFiles();

        if (fichiersParties != null) {
            this.listeParties.setEnabled(true);
            Arrays.sort(fichiersParties);
            for (File fichierPartie : fichiersParties) {
                if (fichierPartie.isFile())
                    this.listeParties.addItem(fichierPartie.getName());
            }
        } else {
            this.listeParties.setEnabled(false);
        }
    }
}