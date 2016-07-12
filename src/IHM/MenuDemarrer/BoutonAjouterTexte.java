package IHM.MenuDemarrer;

import Config.Constantes;
import Config.Ressources;
import Config.Variables;
import IHM.Generiques.BoutonPrincipal;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BoutonAjouterTexte extends BoutonPrincipal {

    public BoutonAjouterTexte(ActionListener listener) {
        super(listener);

        this.setText(" GESTION");
        this.setFont(Variables.POLICE_BOUTON.deriveFont(Float.valueOf(40)));

        if (Variables.THEME.equals(Constantes.THEME_CLAIR))
            this.setIcon(new ImageIcon(Ressources.livre));
        else if (Variables.THEME.equals(Constantes.THEME_SOMBRE))
            this.setIcon(new ImageIcon(Ressources.livre_Sombre));
    }
}