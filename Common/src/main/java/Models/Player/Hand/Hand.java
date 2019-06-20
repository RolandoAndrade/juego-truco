package Models.Player.Hand;

import Models.Card.PlayCard;
import Services.Strategies.Cards.*;

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
    public void searchForSpecial(PlayCard vira)
    {
        for (PlayCard card:cardList)
        {
            if(!(vira.getStrategy() instanceof TenCard) && !(vira.getStrategy() instanceof ElevenCard))
            {
                if(card.getStrategy()instanceof TenCard && card.isSameColor(vira))
                {
                    card.setStrategy(new PericaStrategy());
                }
                else if(card.getStrategy() instanceof ElevenCard && card.isSameColor(vira))
                {
                    card.setStrategy(new PericoStrategy());
                }
            }
            else if ((vira.getStrategy() instanceof TenCard))
            {
                if(card.getStrategy()instanceof ElevenCard && card.isSameColor(vira))
                {
                    card.setStrategy(new PericaStrategy());
                }
                else if(card.getStrategy() instanceof TwelveCard && card.isSameColor(vira))
                {
                    card.setStrategy(new PericoStrategy());
                }
            }
            else
            {
                if(card.getStrategy()instanceof TenCard && card.isSameColor(vira))
                {
                    card.setStrategy(new PericaStrategy());
                }
                else if(card.getStrategy() instanceof TwelveCard && card.isSameColor(vira))
                {
                    card.setStrategy(new PericoStrategy());
                }
            }
            
        }
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
