package Fabriques.Textes;

import Config.Constantes;
import org.mozilla.universalchardet.UniversalDetector;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FabriqueTexteDepuisTxt extends FabriqueTexteDepuisFichier {

    private ArrayList<String> lignesDuTexte;
    private String encodage;

    @Override
    public void setCheminVersFichier(String cheminVersFichier) {
        super.setCheminVersFichier(cheminVersFichier);
        this.detecterEncodage();
    }

    private void detecterEncodage() {
        byte[] buf = new byte[4096];
        UniversalDetector detecteurDeCharset = new UniversalDetector(null);

        int caractActuel;
        FileInputStream fichier;
        try {
            fichier = new FileInputStream(this.cheminVersFichier);
            while ((caractActuel = fichier.read(buf)) > 0 && !detecteurDeCharset.isDone()) {
                detecteurDeCharset.handleData(buf, 0, caractActuel);
            }
            fichier.close();
        } catch (IOException e) {
            if (Constantes.MODE_DEBUG)
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        detecteurDeCharset.dataEnd();

        this.encodage = detecteurDeCharset.getDetectedCharset();
    }

    @Override
    protected void extraireStringsDuFichier() {
        this.lignesDuTexte = new ArrayList<>();
        this.stringsExtraites = new ArrayList<>();

        this.recupererLignesDuTexte();
        this.decouper();
    }

    private void recupererLignesDuTexte() {
        String ligneActuelle;

        try {
            BufferedReader br;
            if (this.encodage != null)
                br = new BufferedReader(new InputStreamReader(new FileInputStream(this.cheminVersFichier), this.encodage));
            else
                br = new BufferedReader(new FileReader(this.cheminVersFichier));
            while ((ligneActuelle = br.readLine()) != null) {
                this.lignesDuTexte.add(ligneActuelle);
                this.lignesDuTexte.add("\n");
            }
            br.close();
        } catch (IOException e) {
            if (Constantes.MODE_DEBUG)
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void decouper() {
        int debutMot;

        for (String ligne : this.lignesDuTexte) {
            debutMot = 0;
            for (int i = 0; i < ligne.length(); i++) {
                if (ligne.charAt(i) == ' ') {
                    this.stringsExtraites.add(ligne.substring(debutMot, i));
                    debutMot = i + 1;
                } else if (ligne.charAt(i) == '.' || ligne.charAt(i) == ','
                        || ligne.charAt(i) == '\'' || ligne.charAt(i) == '\"'
                        || ligne.charAt(i) == '(' || ligne.charAt(i) == ')'
                        || ligne.charAt(i) == '[' || ligne.charAt(i) == ']') {
                    if (ligne.substring(debutMot, i).length() > 0)
                        this.stringsExtraites.add(ligne.substring(debutMot, i));
                    this.stringsExtraites.add(String.valueOf(ligne.charAt(i)));
                    debutMot = i + 1;
                }
            }
            if (ligne.substring(debutMot, ligne.length()).length() > 0)
                this.stringsExtraites.add(ligne.substring(debutMot, ligne.length()));
        }
    }
}