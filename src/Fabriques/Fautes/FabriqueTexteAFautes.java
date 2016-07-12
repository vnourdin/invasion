package Fabriques.Fautes;

import Config.Variables;
import Fabriques.FabriqueTexte;
import Fautes.FauteConjugaison;
import Fautes.FauteGrammaire;
import Fautes.FauteOrthographe;
import Textes.Ligne;
import Textes.Mot;
import Textes.Texte;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class FabriqueTexteAFautes extends FabriqueTexte {

    private final Random generateurAlea = new Random();
    private Texte texteAFalsifier;
    private ArrayList<Ligne> lignesAFalsifier;

    public void setTexteAFalsifier(Texte texte) {
        this.texteAFalsifier = texte;
    }

    @Override
    public Texte creerTexte() {
        this.recupererLignes();
        this.ajouterDesFautesAuxLignes();
        this.ajouterLesLignesAuTexte();
        return this.texteAFabriquer;
    }

    private void recupererLignes() {
        this.lignesAFalsifier = new ArrayList<>();
        this.lignesAFalsifier.addAll(this.texteAFalsifier.getLignes().stream().collect(Collectors.toList()));
    }

    private void ajouterDesFautesAuxLignes() {
        this.texteAFabriquer = new Texte();
        this.lignesAFalsifier.forEach(this::ajouterDesFautesALaLigne);
    }

    private void ajouterLesLignesAuTexte() {
        this.lignesAFalsifier.forEach(this.texteAFabriquer::ajouterLigne);
    }

    private void ajouterDesFautesALaLigne(Ligne ligneAFalsifier) {
        int nbMots = ligneAFalsifier.getNbMots();
        if (nbMots > 0) {
            int nbFautesDansLigne = generateurAlea.nextInt(Variables.NB_MAX_FAUTES_PAR_LIGNE + 1);

            int indexMotFaux;
            Mot motAFalsifier;
            int j;

            for (int i = 0; i < nbFautesDansLigne; i++) {
                j = 0;
                do {
                    indexMotFaux = generateurAlea.nextInt(nbMots);
                    motAFalsifier = ligneAFalsifier.getMot(indexMotFaux);
                    j++;
                } while (j < 3 && !motAFalsifier.estFalsifiable());

                if (motAFalsifier.estFalsifiable())
                    ligneAFalsifier.setMot(indexMotFaux, falsifierMot(motAFalsifier));
            }
        }
    }

    private Mot falsifierMot(Mot motAFalsifier) {
        if (Variables.FAUTES_CONJUGUAISON)
            FauteConjugaison.creerFaute(motAFalsifier);
        if (Variables.FAUTES_GRAMMAIRE)
            FauteGrammaire.creerFaute(motAFalsifier);
        if (Variables.FAUTES_ORTHOGRAPHE)
            FauteOrthographe.creerFaute(motAFalsifier);
        return motAFalsifier;
    }
}