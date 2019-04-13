package Command;

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
            this.deck.mix();
            for(PlayCard card: this.deck.getCards())
                System.out.println(card);
            assertNotNull(deck.getCards());
            assertEquals(40,deck.getCards().size());
        }
        catch (Exception e)
        {
            //este catch DEBE ser cambiado
            e.printStackTrace();
        }
    
    }
}