package IHM.Generiques;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MenuAdapter extends ComponentAdapter {

    protected Menu menu;

    public MenuAdapter(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void componentShown(ComponentEvent e) {
        this.menu.requestFocusInWindow();
    }
}