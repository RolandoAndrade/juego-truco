package Models.Player.Hand;

import Models.Card.PlayCard;

import java.util.ArrayList;

public class Hand implements PlayHand
{

    private ArrayList<PlayCard> cardList;

    public Hand()
    {
        this.cardList = new ArrayList<PlayCard>();
    }
    
    public ArrayList<PlayCard> getCardList()
    {
        return cardList;
    }
    
    public void setCardList(ArrayList<PlayCard> cardList)
    {
        this.cardList = cardList;
    }
    
    @Override
    public void addCard(PlayCard card)
    {
        this.cardList.add(card);
    }
    
    @Override
    public String toString()
    {
        return "Hand{" +
                "cardList=" + cardList +
                '}';
    }
}
