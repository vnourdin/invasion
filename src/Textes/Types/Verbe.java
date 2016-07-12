package Textes.Types;

import java.util.ArrayList;

public class Verbe extends Type {

    public Verbe(String partOfSpeech) {
        this.details = partOfSpeech.split(" ");
    }

    public String getMode() {
        return this.details[1];
    }

    public String getTemps() {
        if (this.estConjugue())
            return this.details[2];
        else
            return "";
    }

    public String getPersonne() {
        if (this.estConjugue())
            return this.details[3];
        else
            return "";
    }

    public String getNombre() {
        if (this.estConjugue())
            return this.details[4];
        else
            return "";
    }

    private boolean estConjugue() {
        ArrayList<String> modes = new ArrayList<>();
        modes.add("ind");
        modes.add("con");
        modes.add("sub");
        modes.add("imp");
        return modes.contains(this.details[1]);

    }

    @Override
    public char getChar() {
        return 'V';
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass()
                && this.getMode().equals(((Verbe) other).getMode())
                && this.getNombre().equals(((Verbe) other).getNombre())
                && this.getPersonne().equals(((Verbe) other).getPersonne())
                && this.getTemps().equals(((Verbe) other).getTemps()));
    }
}
