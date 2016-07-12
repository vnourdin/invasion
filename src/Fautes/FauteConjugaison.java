package Fautes;

import Textes.Mot;

public class FauteConjugaison extends Faute {

    public static Mot creerFaute(Mot leMotAFalsifier) {
        if (leMotAFalsifier.estJuste()) {
            fauteCree = false;

            motAFalsifier = leMotAFalsifier;
            nouvelleOrthographe = motAFalsifier.getOrthographeActuelle();

            if (!fauteCree && motAFalsifier.getType().getChar() == 'V') {
                if (nouvelleOrthographe.endsWith("er") || nouvelleOrthographe.endsWith("ée")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 2);
                    nouvelleOrthographe = nouvelleOrthographe + "é";
                    fauteCree = true;
                } else if (nouvelleOrthographe.endsWith("é")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    nouvelleOrthographe += "er";
                    fauteCree = true;
                } else if (nouvelleOrthographe.endsWith("ées")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    fauteCree = true;
                } else if (nouvelleOrthographe.endsWith("ais")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    nouvelleOrthographe += "t";
                } else if (nouvelleOrthographe.endsWith("ait")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    nouvelleOrthographe += "s";
                } else if (nouvelleOrthographe.endsWith("aient")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 5);
                    nouvelleOrthographe += "ait";
                } else if (nouvelleOrthographe.endsWith("aient")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 5);
                    nouvelleOrthographe += "ai";
                } else if (nouvelleOrthographe.endsWith("ai")) {
                    nouvelleOrthographe += "ais";
                } else if (nouvelleOrthographe.endsWith("ons")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    nouvelleOrthographe += "t";
                } else if (nouvelleOrthographe.endsWith("ont")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    nouvelleOrthographe += "s";
                } else if (nouvelleOrthographe.endsWith("s") || nouvelleOrthographe.endsWith("x")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    fauteCree = true;
                } else if (nouvelleOrthographe.endsWith("s")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                    fauteCree = true;
                } else if (nouvelleOrthographe.endsWith("a")) {
                    nouvelleOrthographe += "s";
                    fauteCree = true;
                } else if (nouvelleOrthographe.equals("est")) {
                    nouvelleOrthographe = "et";
                    fauteCree = true;
                }
            }

            if (fauteCree)
                motAFalsifier.changerOrthographe(nouvelleOrthographe);
        }
        return motAFalsifier;
    }
}