package Fautes;

import Textes.Mot;
import Textes.Types.Nom;

public class FauteOrthographe extends Faute {

    public static Mot creerFaute(Mot leMotAFalsifier) {
        if (leMotAFalsifier.estJuste()) {
            fauteCree = false;

            motAFalsifier = leMotAFalsifier;
            nouvelleOrthographe = motAFalsifier.getOrthographeActuelle();

            fauteGenerique();
            fauteHomonyme();
            fauteDedoublementLettre();
            fauteDoublementLettre();
            fauteGenre();
            inverserDeuxCaracteres();

            if (fauteCree)
                motAFalsifier.changerOrthographe(nouvelleOrthographe);
        }
        return motAFalsifier;
    }

    private static void fauteGenerique() {
        if (!fauteCree) {
            if (nouvelleOrthographe.endsWith("ir")) {
                nouvelleOrthographe += "e";
                fauteCree = true;
            } else if (nouvelleOrthographe.length() > 2 && (nouvelleOrthographe.endsWith("s") || nouvelleOrthographe.endsWith("x"))) {
                nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 1);
                fauteCree = true;
            } else if (nouvelleOrthographe.equals("et")) {
                nouvelleOrthographe = "est";
                fauteCree = true;
            }
        }
    }

    private static void fauteDedoublementLettre() {
        if (!fauteCree) {
            if (nouvelleOrthographe.contains("mm")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("mm", "m");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("pp")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("pp", "p");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("ll")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("ll", "l");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("nn")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("nn", "n");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("ss")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("ss", "s");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("ff")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("ff", "f");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("tt")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("tt", "t");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("cc")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("cc", "c");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("rr")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("rr", "r");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("bb")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("bb", "b");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("dd")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("dd", "d");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("gg")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("gg", "g");
                fauteCree = true;
            }
        }
    }

    private static void fauteDoublementLettre() {
        if (!fauteCree) {
            if (nouvelleOrthographe.contains("m") && !nouvelleOrthographe.contains("mm") && !nouvelleOrthographe.startsWith("m") && !nouvelleOrthographe.endsWith("m")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("m", "mm");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("c") && !nouvelleOrthographe.contains("cc") && !nouvelleOrthographe.startsWith("c") && !nouvelleOrthographe.endsWith("c")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("c", "cc");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("p") && !nouvelleOrthographe.contains("pp") && !nouvelleOrthographe.startsWith("p") && !nouvelleOrthographe.endsWith("p")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("p", "pp");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("l") && !nouvelleOrthographe.contains("ll") && !nouvelleOrthographe.endsWith("l") && !nouvelleOrthographe.startsWith("l")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("l", "ll");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("s") && !nouvelleOrthographe.contains("ss") && !nouvelleOrthographe.endsWith("s") && !nouvelleOrthographe.startsWith("s")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("s", "ss");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("t") && !nouvelleOrthographe.contains("tt") && !nouvelleOrthographe.endsWith("t") && !nouvelleOrthographe.startsWith("t")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("t", "tt");
                fauteCree = true;
            } else if (nouvelleOrthographe.contains("f") && !nouvelleOrthographe.contains("ff") && !nouvelleOrthographe.startsWith("f")) {
                nouvelleOrthographe = nouvelleOrthographe.replace("f", "ff");
                fauteCree = true;
            }
        }
    }

    private static void fauteGenre() {
        if (!fauteCree && motAFalsifier.getType().getChar() == 'N') {
            String genre = ((Nom) motAFalsifier.getType()).getGenre();
            if (genre.equals("m")) {
                if (nouvelleOrthographe.endsWith("el")) {
                    nouvelleOrthographe += "le";
                    fauteCree = true;
                }
            } else if (genre.equals("f")) {
                if (nouvelleOrthographe.endsWith("lle")) {
                    nouvelleOrthographe = nouvelleOrthographe.substring(0, nouvelleOrthographe.length() - 2);
                    fauteCree = true;
                }
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

    private static void inverserDeuxCaracteres() {
        if (!fauteCree) {
            if (nouvelleOrthographe.length() >= 2) {
                int charAChanger = generateurAlea.nextInt(nouvelleOrthographe.length() - 1);

                String avant = nouvelleOrthographe.substring(0, charAChanger);
                char premier = nouvelleOrthographe.charAt(charAChanger);
                char deuxieme = nouvelleOrthographe.charAt(charAChanger + 1);
                String apres = nouvelleOrthographe.substring(charAChanger + 2, nouvelleOrthographe.length());

                nouvelleOrthographe = avant + deuxieme + premier + apres;
                fauteCree = true;
            }
        }
    }
}