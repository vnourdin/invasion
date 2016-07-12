package IHM.MenuFinDePartie;

import IHM.Generiques.Entete;

public class MenuVictoire extends MenuFinDePartie {

    @Override
    protected void ajouterEntete() {
        Entete entete = new Entete("Vous avez gagné !!! Félicitation");
        this.add(entete, this.contrainte);
    }
}