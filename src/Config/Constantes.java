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
    public final static String CHEMIN_RSC = "resources";
    public final static String CHEMIN_POLICES = CHEMIN_RSC + "/Polices";

    public final static String CHEMIN_TEXTES = CHEMIN_RSC + "/Textes";
    public final static String CHEMIN_VERS_SCORE = CHEMIN_RSC + "/score";
    // Sons
    public final static String CHEMIN_SONS = CHEMIN_RSC + "/Sons";
    public final static String CHEMIN_VERS_BIP = CHEMIN_SONS + "/Bip.aiff";
    public final static String CHEMIN_VERS_ERREUR = CHEMIN_SONS + "/erreur.aiff";
    // Icones
    public final static String CHEMIN_IMAGES = CHEMIN_RSC + "/Images";
    public final static String CHEMIN_VERS_COEUR = CHEMIN_IMAGES + "/Coeur.png";
    public final static String CHEMIN_VERS_COEUR_SOMBRE = CHEMIN_IMAGES + "/Coeur_Sombre.png";
    public final static String CHEMIN_VERS_COEURVIDE = CHEMIN_IMAGES + "/CoeurVide.png";
    public final static String CHEMIN_VERS_COEURVIDE_SOMBRE = CHEMIN_IMAGES + "/CoeurVide_Sombre.png";
    public final static String CHEMIN_VERS_SON_ON = CHEMIN_IMAGES + "/Son_ON.png";
    public final static String CHEMIN_VERS_SON_ON_SOMBRE = CHEMIN_IMAGES + "/Son_ON_Sombre.png";
    public final static String CHEMIN_VERS_SON_OFF = CHEMIN_IMAGES + "/Son_OFF.png";
    public final static String CHEMIN_VERS_PEINTURE_ON = CHEMIN_IMAGES + "/Peinture_ON.png";
    public final static String CHEMIN_VERS_PEINTURE_ON_SOMBRE = CHEMIN_IMAGES + "/Peinture_ON_Sombre.png";
    public final static String CHEMIN_VERS_PEINTURE_OFF = CHEMIN_IMAGES + "/Peinture_OFF.png";
    public final static String CHEMIN_VERS_AIDE_ON = CHEMIN_IMAGES + "/Aide_ON.png";
    public final static String CHEMIN_VERS_AIDE_ON_SOMBRE = CHEMIN_IMAGES + "/Aide_ON_Sombre.png";
    public final static String CHEMIN_VERS_AIDE_OFF = CHEMIN_IMAGES + "/Aide_OFF.png";
    public final static String CHEMIN_VERS_CHOIX_ON = CHEMIN_IMAGES + "/Choix_ON.png";
    public final static String CHEMIN_VERS_CHOIX_OFF = CHEMIN_IMAGES + "/Choix_OFF.png";
    public final static String CHEMIN_VERS_CHOIX_ON_SOMBRE = CHEMIN_IMAGES + "/Choix_ON_Sombre.png";
    public final static String CHEMIN_VERS_CHOIX_OFF_SOMBRE = CHEMIN_IMAGES + "/Choix_OFF_Sombre.png";
    // Boutons
    public final static String CHEMIN_BOUTONS = CHEMIN_RSC + "/Boutons";
    public final static String CHEMIN_VERS_JOUER = CHEMIN_BOUTONS + "/Jouer.png";
    public final static String CHEMIN_VERS_JOUER_SOMBRE = CHEMIN_BOUTONS + "/Jouer_Sombre.png";

    public final static String CHEMIN_VERS_LIVRE = CHEMIN_BOUTONS + "/Livre.png";
    public final static String CHEMIN_VERS_LIVRE_SOMBRE = CHEMIN_BOUTONS + "/Livre_Sombre.png";

    public final static String CHEMIN_VERS_OPTIONS = CHEMIN_BOUTONS + "/Options.png";
    public final static String CHEMIN_VERS_OPTIONS_SOMBRE = CHEMIN_BOUTONS + "/Options_Sombre.png";

    public final static String CHEMIN_VERS_ACCUEIL = CHEMIN_BOUTONS + "/Accueil.png";
    public final static String CHEMIN_VERS_ACCUEIL_SOMBRE = CHEMIN_BOUTONS + "/Accueil_Sombre.png";

    public final static String CHEMIN_VERS_QUITTER = CHEMIN_BOUTONS + "/Quitter.png";
    public final static String CHEMIN_VERS_QUITTER_SOMBRE = CHEMIN_BOUTONS + "/Quitter_Sombre.png";


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