package Models.Player.Hand;

import Models.Card.PlayCard;

import java.util.ArrayList;

public class Hand implements PlayHand
{

    private ArrayList<PlayCard> cardList;

    public Hand(ArrayList<PlayCard> cardList)
    {
        this.cardList = cardList;
    }
}
