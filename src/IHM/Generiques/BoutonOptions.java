package IHM.Generiques;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BoutonOptions extends BoutonPrincipal {

    public BoutonOptions(ActionListener listener) {
        super(listener);

        this.setText(" OPTIONS");
        this.setFont(Variables.POLICE_BOUTON.deriveFont(Float.valueOf(40)));

        if (Variables.THEME.equals(Constantes.THEME_CLAIR))
            this.setIcon(new ImageIcon(Ressources.options));
        else if (Variables.THEME.equals(Constantes.THEME_SOMBRE))
            this.setIcon(new ImageIcon(Ressources.options_Sombre));
    }
}