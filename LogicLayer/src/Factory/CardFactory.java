package Factory;

import Models.Card.*;
import Models.Card.Eleven.Eleven;
import Models.Card.Ten.Ten;

import java.util.ArrayList;

public class CardFactory implements CreateCard
{
    
    ArrayList<PlayCard> playCards;
    
    public CardFactory()
    {
        this.playCards = new ArrayList<PlayCard>();
    }
    
    
    @Override
    public ArrayList<PlayCard> createAll()
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
        this.playCards.add(new One(1, "sword"));
        this.playCards.add(new One(1, "gold"));
        this.playCards.add(new One(1, "cup"));
        this.playCards.add(new One(1, "bastos"));
    }
    
    @Override
    public void createAllTwo()
    {
        this.playCards.add(new Two(2, "sword"));
        this.playCards.add(new Two(2, "gold"));
        this.playCards.add(new Two(2, "cup"));
        this.playCards.add(new Two(2, "bastos"));
    }
    
    @Override
    public void createAllThree()
    {
        this.playCards.add(new Three(3, "sword"));
        this.playCards.add(new Three(3, "gold"));
        this.playCards.add(new Three(3, "cup"));
        this.playCards.add(new Three(3, "bastos"));
    }
    
    @Override
    public void createAllFour()
    {
        this.playCards.add(new Four(4, "sword"));
        this.playCards.add(new Four(4, "gold"));
        this.playCards.add(new Four(4, "cup"));
        this.playCards.add(new Four(4, "bastos"));
    }
    
    @Override
    public void createAllFive()
    {
        this.playCards.add(new Five(5, "sword"));
        this.playCards.add(new Five(5, "gold"));
        this.playCards.add(new Five(5, "cup"));
        this.playCards.add(new Five(5, "bastos"));
    }
    
    @Override
    public void createAllSix()
    {
        this.playCards.add(new Six(6, "sword"));
        this.playCards.add(new Six(6, "gold"));
        this.playCards.add(new Six(6, "cup"));
        this.playCards.add(new Six(6, "bastos"));
    }
    
    @Override
    public void createAllSeven()
    {
        this.playCards.add(new Seven(7, "sword"));
        this.playCards.add(new Seven(7, "gold"));
        this.playCards.add(new Seven(7, "cup"));
        this.playCards.add(new Seven(7, "bastos"));
    }
    
    @Override
    public void createAllTen()
    {
        this.playCards.add(new Ten(5, "sword"));
        this.playCards.add(new Ten(5, "gold"));
        this.playCards.add(new Ten(5, "cup"));
        this.playCards.add(new Ten(5, "bastos"));
    }
    
    @Override
    public void createAllEleven()
    {
        this.playCards.add(new Eleven(5, "sword"));
        this.playCards.add(new Eleven(5, "gold"));
        this.playCards.add(new Eleven(5, "cup"));
        this.playCards.add(new Eleven(5, "bastos"));
    }
    
    @Override
    public void createAllTwelve()
    {
        this.playCards.add(new Twelve(5, "sword"));
        this.playCards.add(new Twelve(5, "gold"));
        this.playCards.add(new Twelve(5, "cup"));
        this.playCards.add(new Twelve(5, "bastos"));
    }
    
}
