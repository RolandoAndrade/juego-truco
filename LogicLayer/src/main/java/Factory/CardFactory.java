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
        this.playCards.add(new Card(1, "src/main/resources/sword",new OneCardSword()));
        this.playCards.add(new Card(1, "src/main/resources/gold", new GoldSevenCard()));
        this.playCards.add(new Card(1, "src/main/resources/cup", new OneCardCup()));
        this.playCards.add(new Card(1, "src/main/resources/coarse", new OneCardCoarse()));
    }
    
    private void createSimple(int cardNumber, PlayCardStrategy cardStrategy)
    {
        this.playCards.add(new Card(cardNumber, "src/main/resources/sword",cardStrategy));
        this.playCards.add(new Card(cardNumber, "src/main/resources/gold",cardStrategy));
        this.playCards.add(new Card(cardNumber, "src/main/resources/cup",cardStrategy));
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
        this.playCards.add(new Card(7, "src/main/resources/sword",new SwordSevenCard()));
        this.playCards.add(new Card(7, "src/main/resources/gold", new SwordSevenCard()));
        this.playCards.add(new Card(7, "src/main/resources/cup", new SevenCard()));
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
    
}