package Textes.Types;

public class Determinant extends Type {

    public Determinant(String partOfSpeech) {
        this.details = partOfSpeech.split(" ");
    }

    public String getGenre() {
        if (this.details.length != 1)
            return this.details[1];
        else
            return "";
    }

    public String getNombre() {
        if (this.details.length != 1)
            return this.details[2];
        else
            return "";
    }

    @Override
    public char getChar() {
        return 'D';
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass()
                && this.getGenre().equals(((Determinant) other).getGenre())
                && this.getNombre().equals(((Determinant) other).getNombre()));
    }
}
