package IHM.Generiques;

import Config.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Menu extends JPanel implements ActionListener {
    protected GridBagConstraints contrainte;

    public Menu() {
        super();
        this.setBackground(Variables.COULEUR_FOND);
        this.setLayout(new GridBagLayout());

        this.preparerContrainte();
        this.ajouterEntete();
        this.preparerLesComposants();
        this.ajouterLesComposants();

        this.addComponentListener(new MenuAdapter(this));
    }

    private void preparerContrainte() {
        this.contrainte = new GridBagConstraints();
        this.contrainte.gridx = 0;
        this.contrainte.gridy = 0;
        this.contrainte.gridwidth = 4;
        this.contrainte.weighty = 1;
        this.contrainte.fill = GridBagConstraints.HORIZONTAL;
        this.contrainte.anchor = GridBagConstraints.PAGE_START;
        this.contrainte.weightx = 3;
    }

    protected abstract void ajouterEntete();

    protected abstract void preparerLesComposants();

    protected void ajouterLesComposants() {
        this.contrainte.fill = GridBagConstraints.NONE;
        this.contrainte.anchor = GridBagConstraints.CENTER;
        this.contrainte.weightx = 1;
    }
}