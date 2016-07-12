package Textes.Types;

public class Adjectif extends Type {

    public Adjectif(String partOfSpeech) {
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
        return 'J';
    }

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass()
                && this.getGenre().equals(((Adjectif) other).getGenre())
                && this.getNombre().equals(((Adjectif) other).getNombre()));
    }
}
