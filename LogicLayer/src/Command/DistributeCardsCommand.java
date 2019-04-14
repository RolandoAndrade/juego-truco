package Command;

import Models.Deck.PlayDeck;
import Models.Player.PlayPlayer;
import Models.Player.Player;

import java.util.ArrayList;

public class DistributeCardsCommand extends Command
{
    private PlayDeck deck;
    private ArrayList<PlayPlayer> players;
    
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
            for (int i = 0; i < players.size(); i++)
            {
                player.getHand().addCard(deck.getCards().get(i));
                this.deck.remove(i); //Eliminamos del deck la carta que el usuario toma.
            }
            //se pasa al siguiente usuario
        }
    }
    
    @Override
    public Object Return()
    {
        return null;
    }
}
