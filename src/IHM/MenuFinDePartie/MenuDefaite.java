package IHM.MenuFinDePartie;

import IHM.Generiques.Entete;

public class MenuDefaite extends MenuFinDePartie {

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Vous avez perdu...");
        this.add(entete, this.contrainte);
    }
}