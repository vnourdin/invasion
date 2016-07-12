package IHM.MenuChoixFautes;

import Config.Variables;

import java.awt.event.ActionListener;

public class ChoixGrammaire extends ChoixTypeDeFaute {

    public ChoixGrammaire(ActionListener listener) {
        super("Grammaire", listener);
        this.setSelected(Variables.FAUTES_GRAMMAIRE);
    }
}