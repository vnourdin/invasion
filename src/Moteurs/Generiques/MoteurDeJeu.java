package Moteurs.Generiques;

import Config.Constantes;
import Config.Variables;

import javax.swing.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class MoteurDeJeu extends Thread {

    protected long temps_debut;
    protected Partie partie;
    protected Afficheur afficheur;
    private ArrayList<Dessinable> dessinables;
    private ArrayList<Actualisable> actualisables;
    private ArrayList<Dessinable> dessinablesAAjouter;
    private ArrayList<Actualisable> actualisablesAAjouter;
    private ArrayList<Dessinable> dessinablesASupprimer;
    private ArrayList<Actualisable> actualisablesASupprimer;
    private boolean fini;

    protected MoteurDeJeu() {
        this.initialiser();
    }

    public void associerAfficheur(Afficheur afficheur) {
        this.afficheur = afficheur;
    }

    public void initialiser() {
        this.actualisables = new ArrayList<>();
        this.dessinables = new ArrayList<>();
        this.dessinablesAAjouter = new ArrayList<>();
        this.actualisablesAAjouter = new ArrayList<>();
        this.dessinablesASupprimer = new ArrayList<>();
        this.actualisablesASupprimer = new ArrayList<>();
        this.fini = false;
        this.partie = new Partie();
        Variables.DEPLACEMENT_LIGNE_ACTU = Constantes.DEPLACEMENT_LIGNE_MIN;
        Joueur.getInstance().initialiser();
    }

    public abstract void nouvellePartie(Partie partie);

    public void lancerPartie() {
        this.partie.enCours = true;
        this.partie.estEnPause = false;
        this.afficheur.afficherEtat(Constantes.ID_JEU);
    }

    @Override
    public void run() {
        while (!this.fini) {
            this.actualiserLesListes();
            if (!this.partie.estEnPause) {
                this.temps_debut = System.currentTimeMillis();
                this.actualiser();

                this.afficheur.afficher();

                try {
                    sleep(Constantes.FREQ_MAJ - (System.currentTimeMillis() - this.temps_debut));
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        }
        System.exit(0);
    }

    private void actualiserLesListes() {
        this.dessinables.removeAll(this.dessinablesASupprimer.stream().collect(Collectors.toList()));
        this.dessinablesASupprimer.clear();

        this.actualisables.removeAll(this.actualisablesASupprimer.stream().collect(Collectors.toList()));
        this.actualisablesASupprimer.clear();

        this.dessinables.addAll(this.dessinablesAAjouter.stream().collect(Collectors.toList()));
        this.dessinablesAAjouter.clear();

        this.actualisables.addAll(this.actualisablesAAjouter.stream().collect(Collectors.toList()));
        this.actualisablesAAjouter.clear();
    }

    protected void actualiser() {
        for (Actualisable u : this.actualisables) {
            u.actualiser(this);
        }
    }

    public void ajouterObjet(ObjetDuJeu nouvelObjet) {
        this.dessinablesAAjouter.add(nouvelObjet);
        this.actualisablesAAjouter.add(nouvelObjet);
    }

    public void supprimerObjet(ObjetDuJeu objetASupprimer) {
        this.dessinablesASupprimer.add(objetASupprimer);
        this.actualisablesASupprimer.add(objetASupprimer);
        if (this.actualisablesASupprimer.size() - this.actualisables.size() == 0) {
            this.partie.enCours = false;
            this.afficheur.afficherEtat(Constantes.ID_MENU_VICTOIRE);
        }
    }

    public Partie getPartie() {
        return this.partie;
    }

    public ArrayList<Dessinable> getDessinables() {
        return this.dessinables;
    }

    public void arreter() {
        this.fini = true;
    }
}