package Models.Player;

import Models.Player.Hand.Hand;
import Models.Player.Hand.PlayHand;

public class Player implements PlayPlayer
{
    private String name;
    private PlayHand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new Hand();
    }
    
    public PlayHand getHand()
    {
        return hand;
    }
    
}
