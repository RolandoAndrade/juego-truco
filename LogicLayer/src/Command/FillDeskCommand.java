package Command;

import Factory.CardFactory;
import Factory.CreateCard;
import Models.Card.PlayCard;
import Models.Deck.Deck;
import Models.Deck.PlayDeck;

import java.util.ArrayList;

/**
 * Commando que se encargara de llenar el desk de cartas
 */
public class FillDeskCommand extends Command
{
    PlayDeck deck;
    
    public FillDeskCommand(PlayDeck deck)
    {
        this.deck = deck;
    }
    
    @Override
    public void execute() throws Exception
    {
        CreateCard c = new CardFactory();
        deck.setPlayCards(c.createAll());
    }
    
    @Override
    public ArrayList<PlayCard> Return()
    {
        return null;
    }
}
