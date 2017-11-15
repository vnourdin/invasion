package IHM.MenuGestion.MenuEcrire;

import Config.Constantes;
import IHM.Generiques.BoutonRetour;
import IHM.Generiques.BoutonValider;
import IHM.Generiques.Entete;
import IHM.Generiques.Menu;
import IHM.MenuGestion.SaisieCourte;
import IHM.MenuGestion.SaisieLongue;
import Moteurs.Concrets.AfficheurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MenuEcrire extends Menu {

    private SaisieCourte titre, nomFichier;
    private SaisieLongue texte;
    private JButton valider, retour;
    private JScrollPane scroll;

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Ajouter un texte");
        this.add(entete, this.contrainte);
    }

    @Override
    protected void preparerLesComposants() {
        this.titre = new SaisieCourte("Nom du dossier");
        this.titre.addActionListener(this);
        this.nomFichier = new SaisieCourte("Nom du fichier");
        this.nomFichier.addActionListener(this);
        this.texte = new SaisieLongue("Contenu du texte");

        this.valider = new BoutonValider(this);
        this.retour = new BoutonRetour(this);
        this.scroll = new JScrollPane(this.texte, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    @Override
    protected void ajouterLesComposants() {
        super.ajouterLesComposants();
        this.contrainte.gridy = 1;
        this.add(this.titre, this.contrainte);
        this.contrainte.gridy = 2;
        this.add(this.nomFichier, this.contrainte);
        this.contrainte.gridy = 3;
        this.add(this.scroll, this.contrainte);
        this.contrainte.gridy = 4;
        this.add(this.valider, this.contrainte);


        this.contrainte.anchor = GridBagConstraints.LAST_LINE_END;
        this.contrainte.insets = new Insets(0, 0, 20, 20);
        this.add(this.retour, this.contrainte);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.valider) {
            if (this.titre.getText().length() > 0 && this.nomFichier.getText().length() > 0 && this.texte.getText().length() > 0) {
                String chemin = Constantes.CHEMIN_TEXTES + "/" + this.titre.getText();
                File nouveauDossier = new File(chemin);
                if (!nouveauDossier.exists()) {
                    if (!nouveauDossier.mkdir())
                        JOptionPane.showMessageDialog(null, "Le dossier n'a pas pu être créé !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    File nouveauFichierTexte = new File(chemin + "/" + this.nomFichier.getText());
                    if (nouveauFichierTexte.createNewFile()) {
                        FileWriter fw = new FileWriter(nouveauFichierTexte);
                        BufferedWriter buffered = new BufferedWriter(fw);
                        buffered.write(this.texte.getText());
                        buffered.close();
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
                        }
                        if (JOptionPane.showConfirmDialog(null, "Voulez vous renommer  le fichier en : " + this.nomFichier.getText() + '(' + (nb + 1) + ") ? ", "Fichier déjà existant", JOptionPane.YES_NO_OPTION) == 0) {
                            nouveauFichierTexte.renameTo(new File(split[0] + '(' + (nb + 1) + ")"));
                            FileWriter fw = new FileWriter(nouveauFichierTexte);
                            BufferedWriter buffered = new BufferedWriter(fw);
                            buffered.write(this.texte.getText());
                            buffered.close();
                            JOptionPane.showMessageDialog(null, "Texte Ajouté");
                            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_DEMARRAGE);
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (e.getSource() == this.retour)
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_GESTION);
    }
}