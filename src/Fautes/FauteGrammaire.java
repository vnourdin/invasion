package Fautes;

import Textes.Mot;

public class FauteGrammaire extends Faute {

    public static Mot creerFaute(Mot leMotAFalsifier) {
        if (leMotAFalsifier.estJuste()) {
            fauteCree = false;

            motAFalsifier = leMotAFalsifier;
            nouvelleOrthographe = motAFalsifier.getOrthographeActuelle();

            if (nouvelleOrthographe.equals("a")) {
                nouvelleOrthographe = "à";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("à")) {
                nouvelleOrthographe = "a";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("ou")) {
                nouvelleOrthographe = "où";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("où")) {
                nouvelleOrthographe = "ou";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("se")) {
                nouvelleOrthographe = "ce";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("sa")) {
                nouvelleOrthographe = "ça";
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("ça")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("ça", "sa");
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("ce")) {
                nouvelleOrthographe = "se";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("est")) {
                if (generateurAlea.nextBoolean())
                    nouvelleOrthographe = "sont";
                else
                    nouvelleOrthographe = "ai";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("sont")) {
                nouvelleOrthographe = "est";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("ai")) {
                nouvelleOrthographe = "est";
                fauteCree = true;
            }

            fautePhonetique();
            fauteHomonyme();
        }

        return motAFalsifier;
    }

    private static void fautePhonetique() {
        if (!fauteCree) {
            if (nouvelleOrthographe.endsWith("ant")) {
                nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 3);
                nouvelleOrthographe += "ent";
                fauteCree = true;
            } else if (nouvelleOrthographe.endsWith("ent")) {
                nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 3);
                nouvelleOrthographe += "ant";
                fauteCree = true;
            } else if (nouvelleOrthographe.endsWith("tion")) {
                nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 4);
                nouvelleOrthographe += "ssion";
                fauteCree = true;
            } else if (nouvelleOrthographe.endsWith("ssion")) {
                nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 5);
                nouvelleOrthographe += "tion";
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("sc")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("sc", "ss");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("ph")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("ph", "f");
                fauteCree = true;
            } else if (nouvelleOrthographe.endsWith("t")) {
                nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                fauteCree = true;
            }
        }
    }

    private static void fauteHomonyme() {
        if (!fauteCree) {
            if (nouvelleOrthographe.equals("amande")) {
                nouvelleOrthographe = "amende";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("ancre")) {
                nouvelleOrthographe = "encre";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("encre")) {
                nouvelleOrthographe = "ancre";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("amende")) {
                nouvelleOrthographe = "amande";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("autel")) {
                nouvelleOrthographe = "hôtel";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("hôtel")) {
                nouvelleOrthographe = "autel";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("cygne")) {
                nouvelleOrthographe = "signe";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("signe")) {
                nouvelleOrthographe = "cygne";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("boulot")) {
                nouvelleOrthographe = "bouleau";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("bouleau")) {
                nouvelleOrthographe = "boulot";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("chant")) {
                nouvelleOrthographe = "champs";
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("champs")) {
                nouvelleOrthographe = "chant";
                fauteCree = true;
            }
        }
    }
}