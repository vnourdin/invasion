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

public class BoutonThemeSombre extends BoutonRadio {

    public BoutonThemeSombre() {
        super("SOMBRE");
        this.setBackground(Color.decode("#2ecc71"));
        this.setForeground(Color.decode("#34495e"));

        this.setIcon(new ImageIcon(Ressources.choixOFF_Sombre));
        this.setSelectedIcon(new ImageIcon(Ressources.choixON_Sombre));

        if (Variables.THEME.equals(Constantes.THEME_SOMBRE))
            this.setSelected(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.decode("#27ae60"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.decode("#2ecc71"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!Variables.THEME.equals(Constantes.THEME_SOMBRE)) {
            Variables.THEME = Constantes.THEME_SOMBRE;
            Variables.COULEUR_BOUTONS = Color.decode("#2ecc71");
            Variables.COULEUR_BOUTONS_SURVOL = Color.decode("#27ae60");
            Variables.COULEUR_TEXTE = Color.decode("#ecf0f1");
            Variables.COULEUR_FOND = Color.decode("#34495e");
            Variables.COULEUR_MOT_SELECTIONNE = Color.decode("#9b59b6");
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