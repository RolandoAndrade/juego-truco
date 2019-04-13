package Models.Player.Hand;

import Models.Card.PlayCard;

import java.util.ArrayList;

public class Hand implements IHand
{
    
    private ArrayList<PlayCard> _cardList;
    
    public Hand(ArrayList<PlayCard> _cardList)
    {
        this._cardList = _cardList;
    }
}
