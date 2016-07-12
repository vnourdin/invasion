package Exceptions;

public class MotTropLongException extends Exception {

    public MotTropLongException(String motTopLong) {
        super("Le mot suivant est plus long que la taille maximale d'une ligne : " + motTopLong);
    }
}
