package Moteurs.Generiques;

import Config.Constantes;
import Config.Variables;
import Moteurs.Concrets.AfficheurInvasion;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Joueur {

    public static Joueur joueur;

    private int nbVies;
    private int score;
    private int nbCorrectionsDeSuite;

    private Joueur() {
        this.initialiser();
    }

    public void initialiser() {
        this.nbVies = 3;
        this.nbCorrectionsDeSuite = 0;
        this.score = 0;
    }

    public static synchronized Joueur getInstance() {
        if (joueur == null) joueur = new Joueur();
        return joueur;
    }

    public void gagnerUneVie() {
        if ((this.nbVies + 1) <= Constantes.NB_MAX_VIES)
            this.nbVies++;
    }

    public void perdreUneVie() {
        this.nbVies--;
        if (this.nbVies <= 0)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEFAITE);
    }

    public void actualiserScores() {
        this.enregistrerScore();
    }

    private void enregistrerScore() {
        String scoreMax;
        ArrayList<String> ls = new ArrayList<>();
        ArrayList<String> lt = new ArrayList<>();
        String texte = Variables.TEXTE_CHOISI + ", " + Variables.CHAPITRE_CHOISI;
        if (Variables.PARTIE_CHOISIE != null)
            texte += ", " + Variables.PARTIE_CHOISIE;
        boolean trouve = false;
        try {
            File f = new File(Constantes.CHEMIN_VERS_SCORE);
            if (!f.exists()) {
                f.createNewFile();
            }
            DataInputStream br = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
            while ((scoreMax = br.readLine()) != null) {
                String[] ligne = scoreMax.split(":");
                String t = ligne[0];
                String s = ligne[1];
                ls.add(s);
                lt.add(t);
            }
            br.close();
            DataOutputStream fw = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(Constantes.CHEMIN_VERS_SCORE))));
            for (int i = 0; i < lt.size(); i++) {
                if (lt.get(i).equals(texte)) {
                    trouve = true;
                    if (this.score > Integer.parseInt(ls.get(i)))
                        ls.set(i, String.valueOf(this.score));
                }
            }
            if (!trouve) {
                lt.add(texte);
                ls.add(String.valueOf(this.score));
            }
            for (int i = 0; i < lt.size(); i++) {
                fw.writeBytes(lt.get(i) + ":" + ls.get(i));
                fw.writeBytes("\r\n");
            }
            fw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getNbVies() {
        return this.nbVies;
    }

    public int getScore() {
        return score;
    }

    public void gagnerPoints(int nb) {
        this.score += nb;
    }

    public void perdrePoints(int nb) {
        final int nouveauScore = this.score - nb;
        this.score = (nouveauScore > 0) ? nouveauScore : 0;
    }

    public int getNbCorrectionsDeSuite() {
        return nbCorrectionsDeSuite;
    }

    public void incrementerNbCorrectionsDeSuite() {
        this.nbCorrectionsDeSuite++;
    }

    public void reinitialiserNbCorrectionsDeSuite() {
        this.nbCorrectionsDeSuite = 0;
    }

    public String getMeilleurScore() {
        ArrayList<String> ls = new ArrayList<>();
        ArrayList<String> lt = new ArrayList<>();
        String scoreMax = "0";
        String texte = Variables.TEXTE_CHOISI + ", " + Variables.CHAPITRE_CHOISI;
        if (Variables.PARTIE_CHOISIE != null)
            texte += ", " + Variables.PARTIE_CHOISIE;
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constantes.CHEMIN_VERS_SCORE));
            while ((scoreMax = br.readLine()) != null) {
                String[] ligne = scoreMax.split(":");
                String t = ligne[0];
                String s = ligne[1];
                ls.add(s);
                lt.add(t);
            }
            br.close();
            for (int i = 0; i < lt.size(); i++) {
                if (lt.get(i).equals(texte)) {
                    scoreMax = ls.get(i);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return scoreMax;
    }
}