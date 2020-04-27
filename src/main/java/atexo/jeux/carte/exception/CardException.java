package atexo.jeux.carte.exception;

import lombok.Getter;

@Getter
public class CardException extends RuntimeException {
    private String errorMessage;

    public CardException(String errorMessage, Throwable err) {
        super(errorMessage, err);
        this.errorMessage = errorMessage;
    }

    public CardException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
