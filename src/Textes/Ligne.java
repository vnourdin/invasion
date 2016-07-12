package Textes;

import Config.Constantes;
import Config.Variables;
import Exceptions.MotTropLongException;
import Moteurs.Generiques.Joueur;
import Moteurs.Generiques.MoteurDeJeu;
import Moteurs.Generiques.ObjetDuJeu;

import java.awt.*;
import java.util.ArrayList;

public class Ligne extends ObjetDuJeu {

    private ArrayList<Mot> mots;
    private double largeur;
    private Joueur joueur = Joueur.getInstance();
    private boolean estDejaComptabilisee;

    public Ligne() {
        this.mots = new ArrayList<>();
        this.largeur = 20;
        this.estDejaComptabilisee = false;
    }

    public boolean peutAjouterMot(Mot mot) throws MotTropLongException {
        int tailleMax = Variables.LARGEUR_DE_LA_ZONE_DE_TEXTE;

        if (mot.getLargeur() > tailleMax)
            throw new MotTropLongException(mot.getOrthographeActuelle());

        double nouvelleLargeur = this.largeur + mot.getLargeur() + Constantes.TAILLE_ESPACE;

        return (tailleMax > nouvelleLargeur);
    }

    public void ajouterMot(Mot mot) {
        this.mots.add(mot);
        this.largeur += mot.getLargeur() + Constantes.TAILLE_ESPACE;
    }

    public Mot getMot(int index) {
        return this.mots.get(index);
    }

    public void setMot(int index, Mot nouvelleValeur) {
        this.mots.set(index, nouvelleValeur);
    }

    public int getNbMots() {
        return this.mots.size();
    }

    @Override
    public String toString() {
        String retour = "";
        for (Mot mot : this.mots)
            retour += mot.toString();
        return retour;
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass()
                && this.largeur == ((Ligne) other).largeur
                && this.mots.equals(((Ligne) other).mots));
    }

    @Override
    public void dessiner(Graphics2D g2d) {
        for (Mot mot : this.mots) {
            mot.dessiner(g2d);
        }
    }

    @Override
    public void actualiser(MoteurDeJeu moteur) {
        if (this.y >= Variables.HAUTEUR_DE_LA_BARRE_FIN && !this.estDejaComptabilisee) {
            for (Mot mot : this.mots) {
                if (!mot.estJuste()) {
                    this.joueur.perdreUneVie();
                    this.joueur.reinitialiserNbCorrectionsDeSuite();
                    mot.detruire();
                }
            }
            this.estDejaComptabilisee = true;
        } else if (this.y >= Variables.HAUTEUR_DE_LA_BARRE_FIN + 20) {
            this.detruireDans(moteur);
        } else {
            double tailleActuelle = 20;
            for (Mot mot : this.mots) {
                if (mot.neNecessitePasDespaceAvant() && (tailleActuelle >= Constantes.TAILLE_ESPACE))
                    tailleActuelle -= Constantes.TAILLE_ESPACE;
                mot.setLocation(tailleActuelle, this.getY());
                tailleActuelle += mot.getLargeur();
                if (mot.necessiteUnEspaceApres())
                    tailleActuelle += Constantes.TAILLE_ESPACE;
            }
            this.y += Variables.DEPLACEMENT_LIGNE_ACTU;
        }
    }
}