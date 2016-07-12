package Moteurs.Generiques;

import java.awt.geom.Point2D;

public abstract class ObjetDuJeu extends Point2D.Float implements Dessinable, Actualisable {

    public void ajouterA(MoteurDeJeu moteur) {
        moteur.ajouterObjet(this);
    }

    public void detruireDans(MoteurDeJeu moteur) {
        moteur.supprimerObjet(this);
    }
}