package Models.Player;

import Models.Card.PlayCard;
import Models.Player.Hand.PlayHand;

public interface PlayPlayer
{
    PlayHand getHand();
    String getName();
    void giveCard(PlayCard card);
}
