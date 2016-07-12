package Textes.Types;

public abstract class Type {

    public final static Type NOM = new Nom("N m s");
    public final static Type ADJECTIF = new Adjectif("J m s");
    public final static Type ADVERBE = new Adverbe();
    public final static Type INTERJONCTION = new Interjonction();
    public final static Type ONOMATOPE = new Onomatope();
    public final static Type NOMBRE_CARDINAL = new NombreCardinal();
    public final static Type ABREVIATION = new Abreviation();
    public final static Type NOM_PROPRE = new NomPropre();
    public final static Type MARQUEUR = new Marqueur();
    public final static Type VERBE = new Verbe("V inf");
    public final static Type PREPOSITION = new Preposition();
    public final static Type CONJONCTION = new Conjonction();
    public final static Type DETERMINANT = new Determinant("D");
    public final static Type PRONOM = new Pronom("P m s");
    public final static Type INCONNU = new Inconnu();

    protected String[] details;

    public static Type creerType(String partOfSpeech) {
        if (partOfSpeech.startsWith("N")) return new Nom(partOfSpeech);
        if (partOfSpeech.startsWith("J")) return new Adjectif(partOfSpeech);
        if (partOfSpeech.startsWith("A")) return new Adverbe();
        if (partOfSpeech.startsWith("I")) return new Interjonction();
        if (partOfSpeech.startsWith("O")) return new Onomatope();
        if (partOfSpeech.startsWith("K")) return new NombreCardinal();
        if (partOfSpeech.startsWith("S")) return new Abreviation();
        if (partOfSpeech.startsWith("Z")) return new NomPropre();
        if (partOfSpeech.startsWith("M")) return new Marqueur();
        if (partOfSpeech.startsWith("V")) return new Verbe(partOfSpeech);
        if (partOfSpeech.startsWith("P")) return new Preposition();
        if (partOfSpeech.startsWith("C")) return new Conjonction();
        if (partOfSpeech.startsWith("D")) return new Determinant(partOfSpeech);
        if (partOfSpeech.startsWith("R")) return new Pronom(partOfSpeech);
        else return new Inconnu();
    }

    public abstract char getChar();

    @Override
    public boolean equals(Object other) {
        return (this.getClass() == other.getClass());
    }
}