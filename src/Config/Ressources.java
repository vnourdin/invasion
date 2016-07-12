package Config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Ressources {

    // Icones

    public static BufferedImage coeur;
    public static BufferedImage coeur_Sombre;
    public static BufferedImage coeurVide;
    public static BufferedImage coeurVide_Sombre;

    public static BufferedImage sonON;
    public static BufferedImage sonON_Sombre;
    public static BufferedImage sonOFF;

    public static BufferedImage peintureON;
    public static BufferedImage peintureON_Sombre;
    public static BufferedImage peintureOFF;

    public static BufferedImage aideON;
    public static BufferedImage aideON_Sombre;
    public static BufferedImage aideOFF;

    public static BufferedImage choixON;
    public static BufferedImage choixON_Sombre;
    public static BufferedImage choixOFF;
    public static BufferedImage choixOFF_Sombre;

    // Boutons

    public static BufferedImage jouer;
    public static BufferedImage jouer_Sombre;

    public static BufferedImage livre;
    public static BufferedImage livre_Sombre;

    public static BufferedImage options;
    public static BufferedImage options_Sombre;

    public static BufferedImage accueil;
    public static BufferedImage accueil_Sombre;

    public static BufferedImage quitter;
    public static BufferedImage quitter_Sombre;

    // Sons

    public static AudioClip bip;
    public static AudioClip erreur;

    public static void chargerTout() {
        try {
            Ressources.chargerBoutons();
            Ressources.chargerCoeurs();
            Ressources.chargerIcones();
            Ressources.chargerAudio();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void chargerAudio() throws MalformedURLException {
        bip = Applet.newAudioClip(new File(Constantes.CHEMIN_VERS_BIP).toURI().toURL());
        erreur = Applet.newAudioClip(new File(Constantes.CHEMIN_VERS_ERREUR).toURI().toURL());
    }

    private static void chargerCoeurs() throws IOException {
        coeur = reSize(ImageIO.read(new File(Constantes.CHEMIN_VERS_COEUR)), 30, 30);
        coeur_Sombre = reSize(ImageIO.read(new File(Constantes.CHEMIN_VERS_COEUR_SOMBRE)), 30, 30);
        coeurVide = reSize(ImageIO.read(new File(Constantes.CHEMIN_VERS_COEURVIDE)), 30, 30);
        coeurVide_Sombre = reSize(ImageIO.read(new File(Constantes.CHEMIN_VERS_COEURVIDE_SOMBRE)), 30, 30);
    }

    private static void chargerIcones() throws IOException {
        sonON = ImageIO.read(new File(Constantes.CHEMIN_VERS_SON_ON));
        sonON_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_SON_ON_SOMBRE));
        sonOFF = ImageIO.read(new File(Constantes.CHEMIN_VERS_SON_OFF));
        peintureON = ImageIO.read(new File(Constantes.CHEMIN_VERS_PEINTURE_ON));
        peintureON_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_PEINTURE_ON_SOMBRE));
        peintureOFF = ImageIO.read(new File(Constantes.CHEMIN_VERS_PEINTURE_OFF));
        aideON = ImageIO.read(new File(Constantes.CHEMIN_VERS_AIDE_ON));
        aideON_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_AIDE_ON_SOMBRE));
        aideOFF = ImageIO.read(new File(Constantes.CHEMIN_VERS_AIDE_OFF));
        choixON = ImageIO.read(new File(Constantes.CHEMIN_VERS_CHOIX_ON));
        choixON_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_CHOIX_ON_SOMBRE));
        choixOFF = ImageIO.read(new File(Constantes.CHEMIN_VERS_CHOIX_OFF));
        choixOFF_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_CHOIX_OFF_SOMBRE));
    }

    private static void chargerBoutons() throws IOException {
        jouer = ImageIO.read(new File(Constantes.CHEMIN_VERS_JOUER));
        jouer_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_JOUER_SOMBRE));

        livre = ImageIO.read(new File(Constantes.CHEMIN_VERS_LIVRE));
        livre_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_LIVRE_SOMBRE));

        options = ImageIO.read(new File(Constantes.CHEMIN_VERS_OPTIONS));
        options_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_OPTIONS_SOMBRE));

        accueil = ImageIO.read(new File(Constantes.CHEMIN_VERS_ACCUEIL));
        accueil_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_ACCUEIL_SOMBRE));

        quitter = ImageIO.read(new File(Constantes.CHEMIN_VERS_QUITTER));
        quitter_Sombre = ImageIO.read(new File(Constantes.CHEMIN_VERS_QUITTER_SOMBRE));
    }

    private static BufferedImage reSize(BufferedImage source, int newWidth, int newHeight) {
        double scaleW = (double) newWidth / source.getWidth();
        double scaleH = (double) newHeight / source.getHeight();
        BufferedImage reSizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D draw = reSizedImage.createGraphics();
        draw.scale(scaleW, scaleH);
        draw.drawImage(source, 0, 0, null);
        draw.dispose();
        return reSizedImage;
    }

    public static void changerTheme() {
        BufferedImage tmp;

        tmp = sonON;
        sonON = sonON_Sombre;
        sonON_Sombre = tmp;

        tmp = peintureON;
        peintureON = peintureON_Sombre;
        peintureON_Sombre = tmp;

        tmp = aideON;
        aideON = aideON_Sombre;
        aideON_Sombre = tmp;

        tmp = coeur;
        coeur = coeur_Sombre;
        coeur_Sombre = tmp;

        tmp = coeurVide;
        coeurVide = coeurVide_Sombre;
        coeurVide_Sombre = tmp;
    }
}