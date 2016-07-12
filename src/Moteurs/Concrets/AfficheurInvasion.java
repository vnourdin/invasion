package Moteurs.Concrets;

import Moteurs.Generiques.Afficheur;

public class AfficheurInvasion extends Afficheur {

    private static AfficheurInvasion afficheur;

    public AfficheurInvasion() {
        super();
    }

    public static synchronized AfficheurInvasion getInstance() {
        if (afficheur == null) afficheur = new AfficheurInvasion();
        return afficheur;
    }
}