package Command;

import Models.Deck.Deck;
import Models.Deck.PlayDeck;

public class FactoryCommand
{
    
    public static FillDeskCommand createFillDeskCommand(PlayDeck playDeck)
    {
        return new FillDeskCommand(playDeck);
    }
    
}
