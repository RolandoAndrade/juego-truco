package Models.Game;

import Models.Card.PlayCard;
import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import Models.Player.PlayPlayer;
import java.util.ArrayList;


public class GameRoom implements PlayGame
{
    private ArrayList<PlayPlayer> players;
    private PlayDeck deck;
    private PlayCard vira;
    
    public GameRoom()
    {
        this.players = new ArrayList<>();
        this.deck = new Deck();
    }
    
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
    
    @Override
    public void putVira()
    {
        try
        {
            vira=deck.pickCard();
            for (PlayPlayer p: players)
            {
                p.getHand().searchForSpecial(vira);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void setVira(PlayCard vira)
    {
        this.vira = vira;
    }
    
    public PlayCard getVira()
    {
        return vira;
    }
    
    @Override
    public void cleanPlayedCards()
    {
        for(PlayPlayer p:players)
        {
            p.getHand().removePlayedCard();
        }
    }
    
    public void setDeck(PlayDeck deck)
    {
        this.deck = deck;
    }
}
