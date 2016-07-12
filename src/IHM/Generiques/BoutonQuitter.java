package IHM.Generiques;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BoutonQuitter extends BoutonPrincipal {

    public BoutonQuitter(ActionListener listener) {
        super(listener);

        this.setText(" QUITTER");
        this.setFont(Variables.POLICE_BOUTON.deriveFont(Float.valueOf(43)));

        if (Variables.THEME.equals(Constantes.THEME_CLAIR))
            this.setIcon(new ImageIcon(Ressources.quitter));
        else if (Variables.THEME.equals(Constantes.THEME_SOMBRE))
            this.setIcon(new ImageIcon(Ressources.quitter_Sombre));
    }
}