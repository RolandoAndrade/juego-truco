package Models.Player.Hand;

import Models.Card.PlayCard;

import java.util.ArrayList;

public class Hand implements PlayHand
{

    private ArrayList<PlayCard> cardList;
    private PlayCard playedCard;

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
    public int howManyCardsAre()
    {
        return this.cardList.size();
    }
    
    @Override
    public void putCard(int i)
    {
        this.playedCard=this.cardList.get(i);
        this.cardList.remove(i);
    }
    
    @Override
    public PlayCard getPlayedCard()
    {
        return playedCard;
    }
    
    @Override
    public void removePlayedCard()
    {
        this.playedCard=null;
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
