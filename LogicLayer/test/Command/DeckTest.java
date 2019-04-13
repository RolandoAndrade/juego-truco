package Command;

import Exceptions.DeckEmptyException;
import Models.Card.PlayCard;
import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest
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
    void fillDeckTest()
    {
        try
        {
            fillDeskCommand.execute();
            assertNotNull(deck.getCards());
            assertEquals(40,deck.getCards().size());
        }
        catch (Exception e)
        {
            //este catch DEBE ser cambiado
            e.printStackTrace();
        }
    
    }
    
    @Test
    void mixCardsTest()
    {
        try
        {
            fillDeskCommand.execute();
            List<PlayCard> order=(List<PlayCard>)this.deck.getCards().clone();
            this.deck.mix();
            assertNotEquals(order.toString(), this.deck.getCards().toString());
        }
        catch (Exception e)
        {
            mixCardsTest();
        }
    }
    
    @Test
    void pickCardTest()
    {
        try
        {
            mixCardsTest();
            PlayCard card = this.deck.pickCard();
            assertEquals(39,deck.getCards().size());
            assertNotNull(card);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    void pickTooManyCardsTest()
    {
        try
        {
            mixCardsTest();
            for(int i=0;i<41;i++)
            {
                PlayCard card = this.deck.pickCard();
            }
            assertTrue(false);
        }
        catch (DeckEmptyException e)
        {
            assertTrue(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    void resetDeckWhenIsEmptyTest()
    {
        try
        {
            mixCardsTest();
            for(int i=0;i<41;i++)
            {
                PlayCard card = this.deck.pickCard();
            }
            assertTrue(false);
        }
        catch (DeckEmptyException e)
        {
            fillDeckTest();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}