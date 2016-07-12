package Fabriques;

import Config.Constantes;
import Exceptions.MotTropLongException;
import Textes.Ligne;
import Textes.Mot;
import Textes.Texte;

import javax.swing.*;
import java.util.ArrayList;

public abstract class FabriqueTexte {

    protected Texte texteAFabriquer;
    protected ArrayList<Mot> motsAAjouter;
    private Ligne ligneActuelle;

    private int yDeLaLigneActuelle;

    public abstract Texte creerTexte();

    protected void ajouterLesMotsAuTexte() {
        this.texteAFabriquer = new Texte();
        this.ligneActuelle = new Ligne();
        this.yDeLaLigneActuelle = 0;
        for (Mot motAAjouter : this.motsAAjouter) {
            if (motAAjouter.equals(Mot.RETOUR_CHARIOT))
                this.nouvelleLigneDansTexte();
            else {
                try {
                    if (!this.ligneActuelle.peutAjouterMot(motAAjouter))
                        this.nouvelleLigneDansTexte();
                } catch (MotTropLongException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                this.ligneActuelle.ajouterMot(motAAjouter);
            }
        }
        this.ajouterLigneCouranteAuTexte();
    }

    private void nouvelleLigneDansTexte() {
        this.ajouterLigneCouranteAuTexte();
        this.ligneActuelle = new Ligne();
        this.yDeLaLigneActuelle -= Constantes.ESPACE_INTERLIGNE;
    }

    private void ajouterLigneCouranteAuTexte() {
        this.ligneActuelle.setLocation(0, this.yDeLaLigneActuelle);
        this.texteAFabriquer.ajouterLigne(this.ligneActuelle);
    }
}