package Command;

import Models.Card.Card;
import Models.Card.PlayCard;
import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FillDeskCommandTest
{
    PlayDeck deck;
    Command fillDeskCommand;
    
    @BeforeEach
    void init()
    {
        deck = new Deck();
        fillDeskCommand = FactoryCommand.createFillDeskCommand(deck);
    }
    
    @Test
    void execute()
    {
        try
        {
            fillDeskCommand.execute();
            for(PlayCard card: this.deck.getPlayCards())
                System.out.println(card);
            assertNotNull(deck.getPlayCards());
            assertEquals(40,deck.getPlayCards().size());
        }
        catch (Exception e)
        {
            //este catch DEBE ser cambiado
            e.printStackTrace();
        }
    
    }
}