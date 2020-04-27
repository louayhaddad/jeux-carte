package atexo.jeux.carte.services;

import atexo.jeux.carte.controllers.PlayingCardsController;
import atexo.jeux.carte.exception.CardException;
import atexo.jeux.carte.models.Card;
import atexo.jeux.carte.models.Pack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PlayingCardsServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayingCardsController.class);

    //Le nombre de cartes piochées.
    private static final int NUMBER_OF_HAND_CARDS = 10;


    /**
     * Tire d'une main de n cartes tirées de manière aléatoire.
     * @param packOfCard un paquet de 52 cartes tirées d'une manière aléatoire
     * @return Retourne une liste de 10 cartes non triées.
     */
    public List<Card> distributeCards(Pack packOfCard) {
        LOGGER.info("=====> Distribuer {} cartes.", NUMBER_OF_HAND_CARDS);
        if (NUMBER_OF_HAND_CARDS > packOfCard.getCards().size()) {
            LOGGER.error("=====> Il n'y a plus assez de cartes dans le paquet");
            throw new CardException("Il n'y a plus assez de cartes dans le paquet");
        }
        //Mélange le jeu de cartes
        shuffleCards(packOfCard.getCards());
        // drawn random cards
        return drawnCards(packOfCard);
    }

    /**
     * Trier la main de cartes.
     * @param handCards
     */
    public void OrderdCards(List<Card> handCards) {
        LOGGER.info("=====> Trier la main de cartes.");
        try {
            Comparator<Card> compareByName = Comparator
                    .comparing(Card::getColor)
                    .thenComparing(Card::getValue);
            Collections.sort(handCards, compareByName);
        } catch (Exception e) {
            LOGGER.error("=====> Il ya eu un problème lors du trie des cartes");
            throw new CardException("Il ya eu un problème lors du trie des cartes");
        }
    }

    /**
     * Mélange le jeu de cartes d'une manière aléatoire.
     * @param cards
     */
    private void shuffleCards(List<Card> cards) {
        LOGGER.info("=====> Mélanger les 52 cartes");
        Collections.shuffle(cards);
    }

    /**
     * 1° Extraire les 10 premières cartes du paquet.
     * 2° Mettre à jour les cartes du paquet.
     * @param packOfCard
     * @return Retourne une liste de 10 cartes non triées.
     */
    private List<Card> drawnCards(Pack packOfCard) {
        LOGGER.info("=====> Tirer une main de {} cartes non trié.", NUMBER_OF_HAND_CARDS);
        try {
            List<Card> hand = packOfCard.getCards().subList(0, NUMBER_OF_HAND_CARDS);
            packOfCard.setCards(packOfCard.getCards().subList(NUMBER_OF_HAND_CARDS , packOfCard.getCards().size()));
            return hand;
        } catch (Exception e) {
            LOGGER.error("=====> Il y a eu un problème lors de la distribution des cartes");
            throw new CardException("Il y a eu un problème lors de la distribution des cartes");
        }
    }

}
