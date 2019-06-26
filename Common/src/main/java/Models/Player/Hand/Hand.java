package Models.Player.Hand;

import Models.Card.PlayCard;
import Services.Strategies.Cards.*;

import java.util.ArrayList;

public class Hand implements PlayHand
{

    private ArrayList<PlayCard> cardList;
    private PlayCard playedCard;
    private int envido;
    private int number;

    public Hand()
    {
        this.cardList = new ArrayList<PlayCard>();
        this.envido = 0;
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
    public ArrayList<PlayCard> getCards()
    {
        return cardList;
    }
    
    public int getEnvido(){

        return envido;
    }
    // Creo una lista de las cartas sin el perico o perica
    public ArrayList<PlayCard> noSpecialCards(){
        ArrayList<PlayCard> cards = new ArrayList<PlayCard>();
        for (PlayCard card:cardList){
            if ( (card.getStrategy() != new PericaStrategy()) && (card.getStrategy() != new PericoStrategy()) ) 
                cards.add(card);
        }
        return cards;
    }
    public Boolean haveFlor(){
        
        ArrayList<PlayCard> cards = noSpecialCards();
        if (cardList.get(0).getTypeOfCard() == cardList.get(1).getTypeOfCard() && cardList.get(0).getTypeOfCard() == cardList.get(2).getTypeOfCard())
            return true;
        if (cards.get(0).getTypeOfCard() == cards.get(1).getTypeOfCard()){
            return true;
        }
        return false;
    
    }

    public void setEnvido(){

        if (!haveFlor()){
            
            if (cardList.get(0).getTypeOfCard() == cardList.get(1).getTypeOfCard()){
                this.envido = cardList.get(0).getNumber() + cardList.get(1).getNumber();
            }else if (cardList.get(0).getTypeOfCard() == cardList.get(2).getTypeOfCard()){
                this.envido = cardList.get(0).getNumber() + cardList.get(2).getNumber();
            }else{
                this.envido = cardList.get(1).getNumber() + cardList.get(2).getNumber();
            }
        }
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
    public void setNumber(int number)
    {
        this.number=number;
    }
    
    @Override
    public int getNumber()
    {
        return this.number;
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
