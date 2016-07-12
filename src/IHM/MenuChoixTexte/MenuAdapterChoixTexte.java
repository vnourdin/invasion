package IHM.MenuChoixTexte;

import IHM.Generiques.MenuAdapter;

import java.awt.event.ComponentEvent;

public class MenuAdapterChoixTexte extends MenuAdapter {

    public MenuAdapterChoixTexte(MenuChoixTexte menu) {
        super(menu);
    }

    @Override
    public void componentShown(ComponentEvent e) {
        ((MenuChoixTexte) this.menu).actualiserListeLivres();
    }
}