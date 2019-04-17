package Models.Game;

import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import Models.Player.PlayPlayer;
import java.util.ArrayList;


public class GameRoom implements PlayGame
{
    private ArrayList<PlayPlayer> players;
    private PlayDeck deck;
    
    public GameRoom(ArrayList<PlayPlayer> players)
    {
        this.players = players;
        this.deck = new Deck();
    }
    
    public ArrayList<PlayPlayer> getPlayers()
    {
        return players;
    }
    
    public PlayPlayer getPlayer(int i)
    {
        return players.get(i);
    }
    
    public void setPlayers(ArrayList<PlayPlayer> players)
    {
        this.players = players;
    }
    
    public PlayDeck getDeck()
    {
        return deck;
    }
    
    public void setDeck(PlayDeck deck)
    {
        this.deck = deck;
    }
}
