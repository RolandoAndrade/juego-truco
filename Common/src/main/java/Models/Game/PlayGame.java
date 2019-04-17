package Models.Game;

import Models.Deck.PlayDeck;
import Models.Player.PlayPlayer;

import java.util.ArrayList;

public interface PlayGame
{
    ArrayList<PlayPlayer> getPlayers();
    PlayPlayer getPlayer(int i);
    void setPlayers(ArrayList<PlayPlayer> players);
    PlayDeck getDeck();
    
}
