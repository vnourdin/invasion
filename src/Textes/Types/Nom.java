package Textes.Types;

public class Nom extends Type {

    public Nom(String partOfSpeech) {
        this.details = partOfSpeech.split(" ");
    }

    public String getGenre() {
        return this.details[1];
    }

    public String getNombre() {
        return this.details[2];
    }

    @Override
    public char getChar() {
        return 'N';
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass()
                && this.getGenre().equals(((Nom) other).getGenre())
                && this.getNombre().equals(((Nom) other).getNombre()));
    }
}
