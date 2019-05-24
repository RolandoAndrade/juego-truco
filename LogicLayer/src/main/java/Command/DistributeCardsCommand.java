package Command;

import Models.Deck.PlayDeck;
import Models.Player.PlayPlayer;
import Models.Player.Player;

import java.util.ArrayList;

public class DistributeCardsCommand extends Command
{
    private PlayDeck deck;
    private ArrayList<PlayPlayer> players;
    private final int NUMBER_OF_CARDS = 3;
    
    public DistributeCardsCommand(PlayDeck deck, ArrayList<PlayPlayer> players)
    {
        this.deck = deck;
        this.players = players;
    }
    
    @Override
    public void execute() throws Exception
    {
        for (PlayPlayer player : players)
        {
            for (int i = 0; i < NUMBER_OF_CARDS; i++)
            {
                player.giveCard(deck.pickCard());
            }
        }
    }
    
    @Override
    public Object Return()
    {
        return null;
    }
}
