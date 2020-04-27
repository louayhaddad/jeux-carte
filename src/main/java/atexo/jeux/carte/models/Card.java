package atexo.jeux.carte.models;

import atexo.jeux.carte.enums.ColorEnum;
import atexo.jeux.carte.enums.ValueCardEnum;
import lombok.*;

/**
 * Classe représentant une carte de jeu.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Card {

    /** Le type de la carte. */
    private ValueCardEnum value;

    /** La couleur de la carte. */
    private ColorEnum color;


    /**
     * Retourne une représentation de la carte.
     * @return Renvoie une représentation de la carte.
     */
    @Override
    public String toString()
    {
        return this.value.getValue() + " de " + this.color.getValue();
    }

}
