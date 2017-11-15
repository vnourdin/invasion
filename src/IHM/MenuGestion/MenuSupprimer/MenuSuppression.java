package IHM.MenuGestion.MenuSupprimer;

import Config.Constantes;
import Config.Variables;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.BoutonValider;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import IHM.MenuGestion.ListeDeroulante;
import Moteurs.Concrets.AfficheurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Arrays;

public class MenuSuppression extends Menu {

    private ListeDeroulante listeLivres, listeChapitres, listeParties;
    private JButton retour, valider;

    protected void ajouterEntete() {
        Entete entete = new Entete("Supprimer un texte");
        this.add(entete, this.contrainte);
    }

    protected void preparerLesComposants() {
        this.listeLivres = new ListeDeroulante(this);
        this.listeChapitres = new ListeDeroulante(this);
        this.listeParties = new ListeDeroulante(this);
        this.valider = new BoutonValider(this);
        this.retour = new BoutonRetour(this);

        this.addComponentListener(new MenuAdapterSuppression(this));
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
        this.add(this.valider, this.contrainte);

        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.valider) {
            Variables.TEXTE_CHOISI = this.listeLivres.getSelectedItem().toString();
            Variables.CHAPITRE_CHOISI = this.listeChapitres.getSelectedItem().toString();
            String cheminVersTexte = Constantes.CHEMIN_TEXTES
                    + "/" + Variables.TEXTE_CHOISI
                    + "/" + Variables.CHAPITRE_CHOISI;
            String dossier = Constantes.CHEMIN_TEXTES + "/" + Variables.TEXTE_CHOISI;
            if (this.listeParties.isEnabled()) {
                Variables.PARTIE_CHOISIE = this.listeParties.getSelectedItem().toString();
                cheminVersTexte += "/" + Variables.PARTIE_CHOISIE;
                dossier += "/" + Variables.CHAPITRE_CHOISI;
            }
            if (JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer : " + cheminVersTexte + "? ", "Confirmer la suppression", JOptionPane.YES_NO_OPTION) == 0) {
                File f = new File(cheminVersTexte);
                f.delete();
                File dossierParent = new File(dossier);
                File[] liste = dossierParent.listFiles();
                if (liste.length == 0) {
                    File parent = dossierParent.getParentFile();
                    dossierParent.delete();
                    if (parent.listFiles().length == 0) {
                        parent.delete();
                    }
                }
                JOptionPane.showMessageDialog(null, "Texte Supprimé !");
                AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_GESTION);
            }
        } else if (e.getSource() == this.listeLivres)
            this.actualiserListeChapitres();
        else if (e.getSource() == this.listeChapitres)
            this.actualiserListeParties();
        else if (e.getSource() == this.retour)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_GESTION);

        this.requestFocusInWindow();
    }

    public void actualiserListeLivres() {
        this.listeLivres.removeAllItems();
        File[] dossiersLivres = new File(Constantes.CHEMIN_TEXTES).listFiles();
        if (dossiersLivres != null) {
            Arrays.sort(dossiersLivres);
            for (File dossierLivre : dossiersLivres) {
                if (dossierLivre.isDirectory())
                    this.listeLivres.addItem(dossierLivre.getName());
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
        } else
            this.listeChapitres.setEnabled(false);
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
        } else
            this.listeParties.setEnabled(false);
    }
}