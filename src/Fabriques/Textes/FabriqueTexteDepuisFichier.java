package Fabriques.Textes;

import Fabriques.FabriqueTexte;
import Textes.Mot;
import Textes.Texte;
import Textes.Types.Type;
import org.languagetool.tagging.MorfologikTagger;

import java.util.ArrayList;

public abstract class FabriqueTexteDepuisFichier extends FabriqueTexte {

    protected String cheminVersFichier;
    protected ArrayList<String> stringsExtraites;

    public void setCheminVersFichier(String cheminVersFichier) {
        this.cheminVersFichier = cheminVersFichier;
    }

    @Override
    public Texte creerTexte() {
        this.extraireStringsDuFichier();
        this.convertirStringsExtraitesEnMots();
        this.ajouterLesMotsAuTexte();
        return this.texteAFabriquer;
    }

    protected abstract void extraireStringsDuFichier();

    private void convertirStringsExtraitesEnMots() {
        this.motsAAjouter = new ArrayList<>();
        MorfologikTagger mt = new MorfologikTagger("fr/french.dict");
        for (String mot : this.stringsExtraites) {
            if (mot.equals("\n"))
                this.motsAAjouter.add(Mot.RETOUR_CHARIOT);
            else if (mt.tag(mot.toLowerCase()).size() != 0) {
                String partOfSpeech = mt.tag(mot.toLowerCase()).get(0).getPosTag();
                this.motsAAjouter.add(new Mot(mot, Type.creerType(partOfSpeech)));
            } else
                this.motsAAjouter.add(new Mot(mot, Type.INCONNU));
        }
    }
}