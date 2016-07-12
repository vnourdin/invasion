package IHM.MenuGestion.MenuImporter;

import Config.Constantes;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.BoutonValider;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import IHM.MenuGestion.SaisieCourte;
import Moteurs.Concrets.AfficheurInvasion;
import org.mozilla.universalchardet.UniversalDetector;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class MenuImporter extends Menu {

    private SaisieCourte titre, nomFichier, cheminFichier;
    private JButton valider, retour, parcourir;
    private JLabel chemin;

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Importer un texte");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        this.titre = new SaisieCourte("Nom du dossier");
        this.titre.addActionListener(this);
        this.nomFichier = new SaisieCourte("Nom du fichier");
        this.nomFichier.addActionListener(this);
        this.parcourir = new BoutonParcourir(this);
        this.cheminFichier = new SaisieCourte("Cliquer sur Parcourir");
        this.cheminFichier.setEditable(false);
        this.valider = new BoutonValider(this);
        this.retour = new BoutonRetour(this);
        this.chemin = new JLabel();
    }

    @Override
    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.titre, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.nomFichier, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.chemin, this.contrainte);
        this.contrainte.gridy = 4;
        this.add(this.parcourir, this.contrainte);
        this.contrainte.gridy = 5;
        this.add(this.valider, this.contrainte);

        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.valider) {
            if (this.titre.getText().length() > 0 && this.nomFichier.getText().length() > 0 && this.cheminFichier.getText().length() > 0) {
                String chemin = Constantes.CHEMIN_VERS_LES_TEXTES + "/" + this.titre.getText();
                File nouveauDossier = new File(chemin);
                if (!nouveauDossier.exists()) {
                    if (!nouveauDossier.mkdir())
                        JOptionPane.showMessageDialog(null, "Le dossier n'a pas pu être créé !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                BufferedReader fichierSource;
                BufferedWriter fichierDestination;
                String ligne;
                try {
                    File nouveauFichierTexte = new File(chemin + "/" + this.nomFichier.getText());
                    File fichierACopier = new File(this.cheminFichier.getText());
                    if (nouveauFichierTexte.createNewFile()) {
                        String encodage = this.detecterEncodage(fichierACopier.toString());
                        if (encodage != null) {
                            fichierSource = new BufferedReader(new InputStreamReader(new FileInputStream(fichierACopier), encodage));
                            fichierDestination = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nouveauFichierTexte), encodage));
                        } else {
                            fichierSource = new BufferedReader(new FileReader(fichierACopier));
                            fichierDestination = new BufferedWriter(new FileWriter(nouveauFichierTexte));
                        }
                        while ((ligne = fichierSource.readLine()) != null) {
                            fichierDestination.write(ligne);
                        }
                        fichierSource.close();
                        fichierDestination.close();
                        JOptionPane.showMessageDialog(null, "Texte Ajouté");
                        AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
                    } else {
                        File[] listeFichier = nouveauDossier.listFiles();
                        int nb = 0;
                        String[] split = nouveauFichierTexte.toString().split("\\.");
                        for (File aListeFichier : listeFichier) {
                            String[] split2 = aListeFichier.toString().split("\\(");
                            String s = split2[0];
                            if (s.equals(split[0])) {
                                nb++;
                            }
                            if (JOptionPane.showConfirmDialog(null, "Voulez vous renommer le fichier en : " + this.nomFichier.getText() + '(' + (nb + 1) + ')' + " ?", "Fichier déjà existant", JOptionPane.YES_NO_OPTION) == 0) {
                                nouveauFichierTexte.renameTo(new File(split[0] + '(' + (nb + 1) + ")"));
                                String encodage = this.detecterEncodage(fichierACopier.toString());
                                if (encodage != null) {
                                    fichierSource = new BufferedReader(new InputStreamReader(new FileInputStream(fichierACopier), encodage));
                                    fichierDestination = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nouveauFichierTexte), encodage));
                                } else {
                                    fichierSource = new BufferedReader(new FileReader(fichierACopier));
                                    fichierDestination = new BufferedWriter(new FileWriter(nouveauFichierTexte));
                                }
                                while ((ligne = fichierSource.readLine()) != null) {
                                    fichierDestination.write(ligne);
                                }
                                fichierSource.close();
                                fichierDestination.close();
                                JOptionPane.showMessageDialog(null, "Texte Ajouté");
                                AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);

                            }
                        }
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == this.parcourir) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Fichier .txt", "txt");
            chooser.setFileFilter(filter);
            chooser.setApproveButtonText("Importer");
            int returnVal = chooser.showOpenDialog(this.getParent());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                this.chemin.setText(chooser.getSelectedFile().getAbsolutePath());
                this.cheminFichier.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        } else if (e.getSource() == this.retour) {
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_GESTION);
        }
    }

    private String detecterEncodage(String chemin) {
        byte[] buf = new byte[4096];
        UniversalDetector detecteurDeCharset = new UniversalDetector(null);

        int caractActuel;
        FileInputStream fichier;
        try {
            fichier = new FileInputStream(chemin);
            while ((caractActuel = fichier.read(buf)) > 0 && !detecteurDeCharset.isDone()) {
                detecteurDeCharset.handleData(buf, 0, caractActuel);
            }
            fichier.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        detecteurDeCharset.dataEnd();

        return detecteurDeCharset.getDetectedCharset();
    }
}