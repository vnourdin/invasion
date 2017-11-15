package Config;

import Textes.Texte;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Variables {

    /**
     * Tailles
     */
    public static int LARGEUR_DE_LA_ZONE_DE_TEXTE = ((Constantes.LARGEUR_ECRAN * 2) / 3);
    public static int HAUTEUR_DE_LA_ZONE_DE_TEXTE = ((Constantes.HAUTEUR_ECRAN * 2) / 3);

    public static int HAUTEUR_DE_LA_ZONE_DE_SAISIE = HAUTEUR_DE_LA_ZONE_DE_TEXTE / 10;

    public static int LARGEUR_DE_LA_FENETRE = LARGEUR_DE_LA_ZONE_DE_TEXTE;
    public static int HAUTEUR_DE_LA_FENETRE = HAUTEUR_DE_LA_ZONE_DE_TEXTE + HAUTEUR_DE_LA_ZONE_DE_SAISIE;

    public static int X_DE_LA_FENETRE = (Constantes.LARGEUR_ECRAN / 2) - (LARGEUR_DE_LA_FENETRE / 2);
    public static int Y_DE_LA_FENETRE = (Constantes.HAUTEUR_ECRAN / 2) - (HAUTEUR_DE_LA_FENETRE / 2);

    /**
     * Personnalisation graphique
     */
    public static String THEME = Constantes.THEME_CLAIR;
    public static Font POLICE = Variables.creerPolice(Constantes.CHEMIN_POLICES + "/OpenSans-Regular.ttf").deriveFont(Font.PLAIN, 18);
    public static Font POLICE_ENTETE = Variables.creerPolice(Constantes.CHEMIN_POLICES + "/OpenSans-Bold.ttf").deriveFont(Font.BOLD, 45);
    public static Font POLICE_BOUTON = Variables.creerPolice(Constantes.CHEMIN_POLICES + "/OpenSans-Bold.ttf").deriveFont(Font.BOLD, 18);
    public static Color COULEUR_BOUTONS = Color.decode("#3498db");
    public static Color COULEUR_BOUTONS_SURVOL = Color.decode("#2980b9");
    public static Color COULEUR_TEXTE = Color.decode("#34495e");
    public static Color COULEUR_MOT_JUSTE = Variables.COULEUR_BOUTONS;
    public static Color COULEUR_MOT_FAUX = Color.decode("#c0392b");
    public static Color COULEUR_MOT_SELECTIONNE = Color.decode("#27ae60");
    public static Color COULEUR_BARRE = Variables.COULEUR_TEXTE;
    public static Color COULEUR_BARRE_FIN = Variables.COULEUR_MOT_FAUX;
    public static Color COULEUR_FOND = Color.decode("#ecf0f1");
    public static Color COULEUR_FOND_ZONE_DE_SAISIE = Variables.COULEUR_TEXTE;
    public static Color COULEUR_DESACTIVE = Color.decode("#95a5a6");

    private static Font creerPolice(String cheminVersPolice) {
        File ttf = new File(cheminVersPolice);
        Font laPolice = null;
        try {
            laPolice = Font.createFont(Font.TRUETYPE_FONT, ttf);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return laPolice;
    }

    /**
     * Paramètres du jeu
     */
    public static String TEXTE_CHOISI;
    public static String CHAPITRE_CHOISI;
    public static String PARTIE_CHOISIE;
    public static Texte TEXTE_DE_LA_PARTIE;

    public static int HAUTEUR_DE_LA_BARRE_AIDE = HAUTEUR_DE_LA_FENETRE * 3 / 5;
    public static int HAUTEUR_DE_LA_BARRE_FIN = HAUTEUR_DE_LA_FENETRE * 9 / 10;
    public static double DEPLACEMENT_LIGNE_ACTU = 0.15;
    public static int NB_MAX_FAUTES_PAR_LIGNE = 4;

    /**
     * Options
     */
    public static boolean SON = true;
    public static boolean COLORER_MOT_SELECTIONE = true;
    public static boolean AFFICHER_BARRE_DELIMITATION = true;
    public static boolean FAUTES_CONJUGUAISON = true;
    public static boolean FAUTES_GRAMMAIRE = true;
    public static boolean FAUTES_ORTHOGRAPHE = true;
}