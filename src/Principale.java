import Config.Ressources;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Concrets.MoteurInvasion;

public class Principale {

    public static void main(String[] args) {
        Ressources.chargerTout();
        MoteurInvasion moteurInvasion = MoteurInvasion.getInstance();
        AfficheurInvasion.getInstance();
        moteurInvasion.start();
    }
}