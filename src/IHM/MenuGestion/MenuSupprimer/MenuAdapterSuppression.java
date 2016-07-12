package IHM.MenuGestion.MenuSupprimer;

import IHM.Generiques.MenuAdapter;

import java.awt.event.ComponentEvent;

public class MenuAdapterSuppression extends MenuAdapter {

    public MenuAdapterSuppression(MenuSuppression menu) {
        super(menu);
    }

    @Override
    public void componentShown(ComponentEvent e) {
        ((MenuSuppression) this.menu).actualiserListeLivres();
    }
}