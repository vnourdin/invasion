package IHM.Generiques;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BoutonAccueil extends BoutonPrincipal {

    public BoutonAccueil(ActionListener listener) {
        super(listener);

        this.setText(" ACCUEIL");
        this.setFont(Variables.POLICE_BOUTON.deriveFont(Float.valueOf(43)));

        if (Variables.THEME.equals(Constantes.THEME_CLAIR))
            this.setIcon(new ImageIcon(Ressources.accueil));
        else if (Variables.THEME.equals(Constantes.THEME_SOMBRE))
            this.setIcon(new ImageIcon(Ressources.accueil_Sombre));
    }
}