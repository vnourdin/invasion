package IHM.Generiques;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BoutonJouer extends BoutonPrincipal {

    public BoutonJouer(ActionListener listener) {
        super(listener);

        this.setText(" JOUER");
        this.setFont(Variables.POLICE_BOUTON.deriveFont(Float.valueOf(55)));

        if (Variables.THEME.equals(Constantes.THEME_CLAIR))
            this.setIcon(new ImageIcon(Ressources.jouer));
        else if (Variables.THEME.equals(Constantes.THEME_SOMBRE))
            this.setIcon(new ImageIcon(Ressources.jouer_Sombre));
    }
}