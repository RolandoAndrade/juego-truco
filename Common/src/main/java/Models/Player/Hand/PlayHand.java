package Models.Player.Hand;

import Models.Card.PlayCard;

import java.util.ArrayList;

public interface PlayHand
{
    void addCard(PlayCard card);
    void setCardList(ArrayList<PlayCard> cardList);
    int howManyCardsAre();
    void putCard(int i);
    PlayCard getPlayedCard();
}
