package IHM.MenuOptions.MenuTheme;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;
import IHM.Generiques.BoutonRadio;
import Moteurs.Concrets.AfficheurInvasion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class BoutonThemeClair extends BoutonRadio {

    public BoutonThemeClair() {
        super("CLAIR");
        this.setBackground(Color.decode("#3498db"));
        this.setForeground(Color.decode("#ecf0f1"));

        this.setIcon(new ImageIcon(Ressources.choixOFF));
        this.setSelectedIcon(new ImageIcon(Ressources.choixON));

        if (Variables.THEME.equals(Constantes.THEME_CLAIR))
            this.setSelected(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.decode("#2980b9"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.decode("#3498db"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Variables.THEME.equals(Constantes.THEME_CLAIR)) {
            Variables.THEME = Constantes.THEME_CLAIR;
            Variables.COULEUR_BOUTONS = Color.decode("#3498db");
            Variables.COULEUR_BOUTONS_SURVOL = Color.decode("#2980b9");
            Variables.COULEUR_TEXTE = Color.decode("#34495e");
            Variables.COULEUR_FOND = Color.decode("#ecf0f1");
            Variables.COULEUR_MOT_SELECTIONNE = Color.decode("#27ae60");
            Variables.COULEUR_MOT_JUSTE = Variables.COULEUR_BOUTONS;
            Variables.COULEUR_FOND_ZONE_DE_SAISIE = Variables.COULEUR_TEXTE;
            Variables.COULEUR_BARRE = Variables.COULEUR_TEXTE;
            Variables.COULEUR_BARRE_FIN = Variables.COULEUR_MOT_FAUX;
            Ressources.changerTheme();

            AfficheurInvasion.getInstance().initialiser();
            AfficheurInvasion.getInstance().afficherEtat(Constantes.ID_MENU_THEME);
        }
    }
}