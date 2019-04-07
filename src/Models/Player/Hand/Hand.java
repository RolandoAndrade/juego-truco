package Models.Player.Hand;

import Models.Card.ICard;

import java.util.ArrayList;

public class Hand implements IHand{

    private ArrayList<ICard> _cardList;

    public Hand(ArrayList<ICard> _cardList) {
        this._cardList = _cardList;
    }
}
