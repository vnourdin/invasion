package IHM.MenuChoixFautes;

import Config.Variables;

import java.awt.event.ActionListener;

public class ChoixConjugaison extends ChoixTypeDeFaute {

    public ChoixConjugaison(ActionListener listener) {
        super("Conjugaison", listener);
        this.setSelected(Variables.FAUTES_CONJUGUAISON);
    }
}