package Config;

import java.awt.*;

public class Constantes {

    /**
     * Personnalisation graphique
     */
    public final static String NOM_DU_JEU = "L'INVASION DES FAUTES D'ORTHOGRAPHE";
    public final static String THEME_CLAIR = "THEME CLAIR";
    public final static String THEME_SOMBRE = "THEME SOMBRE";

    /**
     * Id des JPanels
     */
    public final static String ID_JEU = "JEU";
    public final static String ID_MENU_DEMARRAGE = "DEMARRAGE";
    public final static String ID_MENU_FAUTES = "FAUTES";
    public final static String ID_MENU_LIVRES = "LIVRES";
    public final static String ID_MENU_PAUSE = "PAUSE";
    public final static String ID_MENU_OPTIONS = "OPTIONS";
    public final static String ID_MENU_THEME = "THEME";
    public final static String ID_MENU_GESTION = "GESTION";
    public final static String ID_MENU_ECRIRE = "ECRIRE";
    public final static String ID_MENU_IMPORTER = "IMPORTER";
    public final static String ID_MENU_VICTOIRE = "VICTOIRE";
    public static final String ID_MENU_DEFAITE = "DEFAITE";
    public final static String ID_MENU_A_PROPOS = "A PROPOS";
    public final static String ID_MENU_SUPPRIMER_TEXTE = "SUPPRIMER";

    /**
     * Differents chemins vers des fichiers
     */
    public final static String CHEMIN_VERS_LES_TEXTES = "Ressources/Textes";
    public final static String CHEMIN_VERS_SCORE = "Ressources/score";
    // Sons
    public final static String CHEMIN_VERS_BIP = "Ressources/Sons/Bip.aiff";
    public final static String CHEMIN_VERS_ERREUR = "Ressources/Sons/erreur.aiff";
    // Icones
    public final static String CHEMIN_VERS_COEUR = "Ressources/Images/Coeur.png";
    public final static String CHEMIN_VERS_COEUR_SOMBRE = "Ressources/Images/Coeur_Sombre.png";
    public final static String CHEMIN_VERS_COEURVIDE = "Ressources/Images/CoeurVide.png";
    public final static String CHEMIN_VERS_COEURVIDE_SOMBRE = "Ressources/Images/CoeurVide_Sombre.png";
    public final static String CHEMIN_VERS_SON_ON = "Ressources/Images/Son_ON.png";
    public final static String CHEMIN_VERS_SON_ON_SOMBRE = "Ressources/Images/Son_ON_Sombre.png";
    public final static String CHEMIN_VERS_SON_OFF = "Ressources/Images/Son_OFF.png";
    public final static String CHEMIN_VERS_PEINTURE_ON = "Ressources/Images/Peinture_ON.png";
    public final static String CHEMIN_VERS_PEINTURE_ON_SOMBRE = "Ressources/Images/Peinture_ON_Sombre.png";
    public final static String CHEMIN_VERS_PEINTURE_OFF = "Ressources/Images/Peinture_OFF.png";
    public final static String CHEMIN_VERS_AIDE_ON = "Ressources/Images/Aide_ON.png";
    public final static String CHEMIN_VERS_AIDE_ON_SOMBRE = "Ressources/Images/Aide_ON_Sombre.png";
    public final static String CHEMIN_VERS_AIDE_OFF = "Ressources/Images/Aide_OFF.png";
    public final static String CHEMIN_VERS_CHOIX_ON = "Ressources/Images/Choix_ON.png";
    public final static String CHEMIN_VERS_CHOIX_OFF = "Ressources/Images/Choix_OFF.png";
    public final static String CHEMIN_VERS_CHOIX_ON_SOMBRE = "Ressources/Images/Choix_ON_Sombre.png";
    public final static String CHEMIN_VERS_CHOIX_OFF_SOMBRE = "Ressources/Images/Choix_OFF_Sombre.png";
    // Boutons
    public final static String CHEMIN_VERS_JOUER = "Ressources/Boutons/Jouer.png";
    public final static String CHEMIN_VERS_JOUER_SOMBRE = "Ressources/Boutons/Jouer_Sombre.png";

    public final static String CHEMIN_VERS_LIVRE = "Ressources/Boutons/Livre.png";
    public final static String CHEMIN_VERS_LIVRE_SOMBRE = "Ressources/Boutons/Livre_Sombre.png";

    public final static String CHEMIN_VERS_OPTIONS = "Ressources/Boutons/Options.png";
    public final static String CHEMIN_VERS_OPTIONS_SOMBRE = "Ressources/Boutons/Options_Sombre.png";

    public final static String CHEMIN_VERS_ACCUEIL = "Ressources/Boutons/Accueil.png";
    public final static String CHEMIN_VERS_ACCUEIL_SOMBRE = "Ressources/Boutons/Accueil_Sombre.png";

    public final static String CHEMIN_VERS_QUITTER = "Ressources/Boutons/Quitter.png";
    public final static String CHEMIN_VERS_QUITTER_SOMBRE = "Ressources/Boutons/Quitter_Sombre.png";


    /**
     * Autres constantes
     */
    public final static int NB_MAX_VIES = 5;
    public final static int ESPACE_INTERLIGNE = 30;
    public final static double TAILLE_ESPACE = 6.0;
    public final static int FREQ_MAJ = 25;
    public static double DEPLACEMENT_LIGNE_MIN = 0.15;
    public final static boolean MODE_DEBUG = true;

    /**
     * Tailles des differents elements
     */
    public final static int LARGEUR_ECRAN = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
    public final static int HAUTEUR_ECRAN = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();

    public final static Dimension TAILLE_BOUTON = new Dimension(280, 80);
    public final static int LARGEUR_COEURS = (Constantes.NB_MAX_VIES * Ressources.coeur.getWidth()) + (Constantes.NB_MAX_VIES * 5);
}