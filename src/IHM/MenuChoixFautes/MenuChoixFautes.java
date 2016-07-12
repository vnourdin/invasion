package IHM.MenuChoixFautes;

import Config.Constantes;
import Config.Variables;
import IHM.Generiques.*;
import IHM.Generiques.Menu;
import Moteurs.Concrets.AfficheurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuChoixFautes extends Menu implements ActionListener {

    private ChoixTypeDeFaute conjugaison, grammaire, orthographe;
    private Bouton suivant, retour;

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Choix du type de fautes");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        this.conjugaison = new ChoixConjugaison(this);
        this.grammaire = new ChoixGrammaire(this);
        this.orthographe = new ChoixOrthographe(this);

        this.suivant = new BoutonValider(this);
        this.retour = new BoutonRetour(this);
    }

    @Override
    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.conjugaison, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.grammaire, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.orthographe, this.contrainte);
        this.contrainte.gridy = 4;
        this.add(this.suivant, this.contrainte);

        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.conjugaison)
            Variables.FAUTES_CONJUGUAISON = this.conjugaison.isSelected();
        else if (e.getSource() == this.grammaire)
            Variables.FAUTES_GRAMMAIRE = this.grammaire.isSelected();
        else if (e.getSource() == this.orthographe)
            Variables.FAUTES_ORTHOGRAPHE = this.orthographe.isSelected();
        else if (e.getSource() == this.suivant)
            if (this.orthographe.isSelected() || this.conjugaison.isSelected() || this.grammaire.isSelected())
                AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_LIVRES);
            else {
                JOptionPane.showMessageDialog(null, "Veuillez choisir au minimum un type de faute", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        else if (e.getSource() == this.retour)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
    }
}