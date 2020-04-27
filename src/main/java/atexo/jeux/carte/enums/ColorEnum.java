package atexo.jeux.carte.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ColorEnum {
    CARREAU("carreau"),
    COEUR("coeur"),
    PIQUE("pique"),
    TREFLE("trefle");

    private String value;
}
