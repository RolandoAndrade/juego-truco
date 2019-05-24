package Models.Player;

import Models.Card.PlayCard;
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
    
    public PlayHand getHand()
    {
        return hand;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public void giveCard(PlayCard card)
    {
        this.hand.addCard(card);
    }
}
