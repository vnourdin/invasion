package Fautes;

import Textes.Mot;

import java.util.Random;

public abstract class Faute {

    protected static final Random generateurAlea = new Random();
    protected static Mot motAFalsifier;
    protected static String nouvelleOrthographe;
    protected static boolean fauteCree;

    public static boolean aCreeUneFaute() {
        return fauteCree;
    }
}