package Command;

import Factory.CardFactory;
import Models.Card.ICard;
import Models.Deck.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FillDeskCommandTest {
    Deck deck;
    CardFactory cardFactory;
    ArrayList<ICard> cardList;
    FillDeskCommand fillDeskCommand;
    @BeforeEach
    void setUp() {
        this.cardList = new ArrayList<ICard>();
        this.deck = new Deck(cardList);
        this.fillDeskCommand = new FillDeskCommand(this.deck);
    }

    @Test
    void execute() {
        try {
            fillDeskCommand.execute();
            assertNotNull(this.deck);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}