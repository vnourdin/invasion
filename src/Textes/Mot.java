package Textes;

import Config.Variables;
import Moteurs.Concrets.AfficheurInvasion;
import Moteurs.Generiques.MoteurDeJeu;
import Moteurs.Generiques.ObjetDuJeu;
import Textes.Types.Type;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Mot extends ObjetDuJeu {

    public final static Mot RETOUR_CHARIOT = new Mot("\n", Type.MARQUEUR);
    private final static Mot POINT = new Mot(".", Type.MARQUEUR);
    private final static Mot VIRGULE = new Mot(",", Type.MARQUEUR);
    private final static Mot APOSTROPHE = new Mot("'", Type.INCONNU);
    private final static Mot PARENTHESE_OUVRANTE = new Mot("(", Type.INCONNU);
    private final static Mot PARENTHESE_FERMANTE = new Mot(")", Type.INCONNU);
    private String orthographeCorrecte, orthographeActuelle;
    private Type type;
    private boolean estDetruit = false;

    private boolean estSelectionne = false;

    public Mot(String orthographe, Type type) {
        this.orthographeCorrecte = orthographe;
        this.orthographeActuelle = orthographe;
        this.type = type;
    }

    public void changerOrthographe(String nouvelleOrthographe) {
        this.orthographeActuelle = nouvelleOrthographe;
    }

    public String getOrthographeActuelle() {
        return this.orthographeActuelle;
    }

    public Type getType() {
        return this.type;
    }

    public double getLargeur() {
        return Variables.POLICE.getStringBounds(
                this.orthographeActuelle,
                AfficheurInvasion.getInstance().getFontRenderContext()).getWidth();
    }

    public boolean estFalsifiable() {
        return (!this.estUnCaractereSpecial()
                && this.estDeTypeFalsifiable()
                && this.estJuste());
    }

    private boolean estUnCaractereSpecial() {
        return (this.equals(POINT)
                || this.equals(VIRGULE)
                || this.equals(APOSTROPHE)
                || this.equals(PARENTHESE_OUVRANTE)
                || this.equals(PARENTHESE_FERMANTE)
                || this.equals(RETOUR_CHARIOT));
    }

    private boolean estDeTypeFalsifiable() {
        return (!this.getType().equals(Type.INCONNU)
                && !this.getType().equals(Type.MARQUEUR)
                && !this.getType().equals(Type.NOM_PROPRE)
                && !this.getType().equals(Type.ONOMATOPE)
                && !this.getType().equals(Type.ABREVIATION));
    }

    public boolean estJuste() {
        return this.orthographeActuelle.equals(this.orthographeCorrecte);
    }

    public boolean neNecessitePasDespaceAvant() {
        return (this.equals(Mot.POINT) || this.equals(Mot.VIRGULE) || this.equals(Mot.APOSTROPHE) || this.equals(Mot.PARENTHESE_FERMANTE));
    }

    public boolean necessiteUnEspaceApres() {
        return (!this.equals(Mot.APOSTROPHE)
                && !this.equals(Mot.POINT)
                && !this.equals(Mot.VIRGULE)
                && !this.equals(Mot.PARENTHESE_OUVRANTE));
    }

    @Override
    public void dessiner(Graphics2D g2d) {
        if (this.y > Variables.HAUTEUR_DE_LA_BARRE_AIDE && Variables.AFFICHER_BARRE_DELIMITATION)
            g2d.setColor((this.estJuste()) ? Variables.COULEUR_MOT_JUSTE : Variables.COULEUR_MOT_FAUX);
        else
            g2d.setColor(Variables.COULEUR_TEXTE);

        if (this.estSelectionne && Variables.COLORER_MOT_SELECTIONE)
            g2d.setColor(Variables.COULEUR_MOT_SELECTIONNE);
        AffineTransform svg = g2d.getTransform();
        g2d.translate(this.x, this.y);
        g2d.drawString(this.orthographeActuelle, /*(int) this.x*/0, /*(int) this.y*/0);
        g2d.setTransform(svg);
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass()
                && this.orthographeActuelle.equals(((Mot) other).orthographeActuelle)
                && this.orthographeCorrecte.equals(((Mot) other).orthographeCorrecte)
                && this.type.equals(((Mot) other).getType()));
    }

    @Override
    public String toString() {
        return this.orthographeActuelle;
    }

    @Override
    public void actualiser(MoteurDeJeu moteur) {
    }

    public void selectionner() {
        this.estSelectionne = true;
    }

    public void deselectionner() {
        this.estSelectionne = false;
    }

    public boolean estSelectionne() {
        return this.estSelectionne;
    }

    public String getOrthographeCorrecte() {
        return this.orthographeCorrecte;
    }

    public boolean estDetruit() {
        return this.estDetruit;
    }

    public void detruire() {
        this.estDetruit = true;
    }

}