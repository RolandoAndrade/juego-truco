package Models.Player;

import Models.Player.Hand.PlayHand;

public class Player implements PlayPlayer
{
    private String name;
    private PlayHand hand;

    public Player(String name, PlayHand hand)
    {
        this.name = name;
        this.hand = hand;
    }
}
