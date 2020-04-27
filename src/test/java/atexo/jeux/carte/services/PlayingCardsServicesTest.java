package atexo.jeux.carte.services;

import atexo.jeux.carte.CardGameApplication;
import atexo.jeux.carte.enums.ColorEnum;
import atexo.jeux.carte.enums.ValueCardEnum;
import atexo.jeux.carte.models.Card;
import atexo.jeux.carte.models.Pack;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = CardGameApplication.class)
class PlayingCardsServicesTest {

    @Autowired
    private PlayingCardsServices playingCardsServices;

    private Pack packOfCards;

    @BeforeEach
    void setUp() {
        packOfCards = new Pack();
    }

    @Test
    void distributeCards() {
        //given

        //when
        List<Card> cards = playingCardsServices.distributeCards(packOfCards);
        //then
        Assert.assertTrue(cards.size() == 10);
        Assert.assertTrue(packOfCards.getCards().size() == 42);
    }

    @Test
    void orderdCards() {
        //given
        List<Card> handCards =Arrays.asList(
                new Card(ValueCardEnum.ROI, ColorEnum.TREFLE),
                new Card(ValueCardEnum.VALET, ColorEnum.COEUR),
                new Card(ValueCardEnum.AS, ColorEnum.PIQUE),
                new Card(ValueCardEnum.CINQ, ColorEnum.TREFLE),
                new Card(ValueCardEnum.DAME, ColorEnum.COEUR),
                new Card(ValueCardEnum.SEPT, ColorEnum.TREFLE),
                new Card(ValueCardEnum.AS, ColorEnum.CARREAU),
                new Card(ValueCardEnum.NEUF, ColorEnum.COEUR),
                new Card(ValueCardEnum.CINQ, ColorEnum.CARREAU),
                new Card(ValueCardEnum.TROIS, ColorEnum.TREFLE)
        );
        //when
        playingCardsServices.OrderdCards(handCards);
        //then
        Assert.assertEquals(ValueCardEnum.AS.getValue(), handCards.get(0).getValue().getValue());
        Assert.assertEquals(ColorEnum.CARREAU.getValue(), handCards.get(0).getColor().getValue());
        Assert.assertEquals(ValueCardEnum.CINQ.getValue(), handCards.get(1).getValue().getValue());
        Assert.assertEquals(ColorEnum.CARREAU.getValue(), handCards.get(1).getColor().getValue());
    }
}
