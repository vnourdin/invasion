package IHM.MenuChoixFautes;

import Config.Variables;

import java.awt.event.ActionListener;

public class ChoixOrthographe extends ChoixTypeDeFaute {

    public ChoixOrthographe(ActionListener listener) {
        super("Orthographe", listener);
        this.setSelected(Variables.FAUTES_ORTHOGRAPHE);
    }
}