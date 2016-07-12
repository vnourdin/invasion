package Textes.Types;

public class Pronom extends Type {

    public Pronom(String partOfSpeech) {
        this.details = partOfSpeech.split(" ");
    }

    public String getGenre() {
        if (this.details[1].equals("rel") || this.details[1].equals("dem"))
            return this.details[2];
        else if (this.details[1].equals("refl") || (this.details[1].equals("pers") && this.details.length == 5))
            return this.details[3];
        else if ((this.details[1].equals("pers") && this.details.length == 4))
            return "";
        else
            return this.details[1];
    }

    public String getNombre() {
        if (this.details[1].equals("rel") || this.details[1].equals("dem"))
            return this.details[3];
        else if (this.details[1].equals("refl") || (this.details[1].equals("pers") && this.details.length == 5))
            return this.details[4];
        else if ((this.details[1].equals("pers") && this.details.length == 4))
            return this.details[3];
        else
            return this.details[2];
    }

    @Override
    public char getChar() {
        return 'R';
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass()
                && this.getGenre().equals(((Pronom) other).getGenre())
                && this.getNombre().equals(((Pronom) other).getNombre()));
    }
}
