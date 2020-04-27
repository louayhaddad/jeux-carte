package atexo.jeux.carte.models;

import atexo.jeux.carte.enums.ColorEnum;
import atexo.jeux.carte.enums.ValueCardEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
public class Pack {

    private List<Card> cards;

    /**
     * Créer un paquet de 52 cartes.
     * Constructeur.
     */
    public Pack() {
        cards = new ArrayList<>();
        // Initialisation des cartes du paquet.
        Stream.of(ColorEnum.values()).forEach(colorEnum -> {
            Stream.of(ValueCardEnum.values()).forEach(valueCardEnum -> {
                cards.add(Card.builder()
                        .color(colorEnum)
                        .value(valueCardEnum)
                        .build()
                );
            });
        } );

    }

}
