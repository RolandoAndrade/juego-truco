package Factory;

import Models.Card.*;
import Services.Strategies.Cards.*;

import java.util.ArrayList;

public class CardFactory implements CreateCard
{
    
    ArrayList<PlayCard> playCards;
    
    public CardFactory()
    {
        this.playCards = new ArrayList<PlayCard>();
    }
    
    
    @Override
    public ArrayList<PlayCard> createDeck()
    {
        createAllOne();
        createAllTwo();
        createAllThree();
        createAllFour();
        createAllFive();
        createAllSix();
        createAllSeven();
        createAllTen();
        createAllEleven();
        createAllTwelve();
        return this.playCards;
    }
    
    @Override
    public void createAllOne()
    {
        this.playCards.add(new Card(1, "sword",new OneCardSword()));
        this.playCards.add(new Card(1, "gold", new GoldSevenCard()));
        this.playCards.add(new Card(1, "cup", new OneCardCup()));
        this.playCards.add(new Card(1, "course", new OneCardCoarse()));
    }
    
    private void createSimple(int cardNumber, PlayCardStrategy cardStrategy)
    {
        this.playCards.add(new Card(cardNumber, "sword",cardStrategy));
        this.playCards.add(new Card(cardNumber, "gold",cardStrategy));
        this.playCards.add(new Card(cardNumber, "cup",cardStrategy));
        this.playCards.add(new Card(cardNumber, "course",cardStrategy));
    }
    
    @Override
    public void createAllTwo()
    {
        createSimple(2,new TwoCard());
    }
    
    @Override
    public void createAllThree()
    {
        createSimple(3, new TreeCard());
    }
    
    @Override
    public void createAllFour()
    {
        createSimple(4, new FourCard());
    }
    
    @Override
    public void createAllFive()
    {
        createSimple(5, new FiveCard());
    }
    
    @Override
    public void createAllSix()
    {
        createSimple(6, new SixCard());
    }
    
    @Override
    public void createAllSeven()
    {
        this.playCards.add(new Card(7, "sword",new SwordSevenCard()));
        this.playCards.add(new Card(7, "gold", new GoldSevenCard()));
        this.playCards.add(new Card(7, "cup", new SevenCard()));
        this.playCards.add(new Card(7, "course", new SevenCard()));
    }
    
    @Override
    public void createAllTen()
    {
        createSimple(10,new TenCard());
    }
    
    @Override
    public void createAllEleven()
    {
        createSimple(11, new ElevenCard());
    }
    
    @Override
    public void createAllTwelve()
    {
        createSimple(12, new TwelveCard());
    }
    
    private String translateType(char type)
    {
        switch (type)
        {
            case 'O':
                return "gold";
            case 'E':
                return "sword";
            case 'B':
                return "course";
            case 'C':
                return "cup";
        }
        return "";
    }
    
    private PlayCard getMultipleOptionsCard(Card c, char type, PlayCardStrategy...playCardStrategies)
    {
        switch (type)
        {
            case 'O':
                c.setStrategy(playCardStrategies[0]);
                break;
            case 'E':
                c.setStrategy(playCardStrategies[1]);
                break;
            case 'B':
                c.setStrategy(playCardStrategies[2]);
                break;
            case 'C':
                c.setStrategy(playCardStrategies[3]);
                break;
        }
        return c;
    }
    
    private PlayCard card(String s)
    {
        int number = Integer.parseInt(s.substring(0,2));
        char type = s.charAt(2);
        String trans = translateType(type);
        switch (number)
        {
            case 1:
                Card c=new Card(1,trans);
                return getMultipleOptionsCard(c,type,new OneCardGold(),
                        new OneCardSword(),new OneCardCoarse(),new OneCardCup());
            case 2:
                return new Card(2,trans,new TwoCard());
            case 3:
                return new Card(2,trans,new TreeCard());
            case 4:
                return new Card(4,trans,new FourCard());
            case 5:
                return new Card(4,trans,new FiveCard());
            case 6:
                return new Card(4,trans,new SixCard());
            case 7:
                Card x=new Card(7,trans);
                return getMultipleOptionsCard(x,type,new GoldSevenCard(),
                        new SwordSevenCard(),new SevenCard(),new SevenCard());
            case 10:
                return new Card(10,trans,new TenCard());
            case 11:
                return new Card(11,trans,new ElevenCard());
            case 12:
                return new Card(12,trans,new TwelveCard());
        }
        return null;
    }
    
    @Override
    public ArrayList<PlayCard> createFromTrama(String s)
    {
        ArrayList<PlayCard> cards = new ArrayList<PlayCard>();
        cards.add(card(s.substring(0,3)));
        cards.add(card(s.substring(3,6)));
        cards.add(card(s.substring(6,9)));
        return cards;
    }
}
