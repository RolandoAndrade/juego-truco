package Command;

import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import org.junit.jupiter.api.BeforeAll;
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
            assertNotNull(deck.getPlayCards());
            assertEquals(40,deck.getPlayCards().size());
        } catch (Exception e)
        {
            //este catch DEBE ser cambiado
            e.printStackTrace();
        }
    
    }
}