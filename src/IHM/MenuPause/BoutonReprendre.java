package IHM.MenuPause;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;
import IHM.Generiques.BoutonPrincipal;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BoutonReprendre extends BoutonPrincipal {

    public BoutonReprendre(ActionListener listener) {
        super(listener);

        this.setText(" REPRENDRE");
        this.setFont(Variables.POLICE_BOUTON.deriveFont(Float.valueOf(30)));

        if (Variables.THEME.equals(Constantes.THEME_CLAIR))
            this.setIcon(new ImageIcon(Ressources.jouer));
        else if (Variables.THEME.equals(Constantes.THEME_SOMBRE))
            this.setIcon(new ImageIcon(Ressources.jouer_Sombre));
    }
}