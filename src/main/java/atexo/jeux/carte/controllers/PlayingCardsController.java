package atexo.jeux.carte.controllers;

import atexo.jeux.carte.models.Card;
import atexo.jeux.carte.models.Pack;
import atexo.jeux.carte.services.PlayingCardsServices;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayingCardsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayingCardsController.class);


    private final PlayingCardsServices playingCardsServices;

    @GetMapping("/random-hand-cards")
    public String saveMetaData(Model model) {
        LOGGER.info("=================================================================================================================");
        LOGGER.info("=============================================== random hand cards ===============================================");
        LOGGER.info("=================================================================================================================");
        List<Card> handCards = playingCardsServices.distributeCards(new Pack());

        List<Card> storedhandCards = new ArrayList<>(handCards);
        playingCardsServices.OrderdCards(storedhandCards);

        model.addAttribute("cards", new Pack().getCards());
        model.addAttribute("randomHandCards", handCards);
        model.addAttribute("storedHandCards", storedhandCards);
        return "random-hand-cards";
    }
}
