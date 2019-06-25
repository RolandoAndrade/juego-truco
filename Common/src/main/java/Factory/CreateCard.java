package Factory;

import Models.Card.PlayCard;

import java.util.ArrayList;

public interface CreateCard
{
    
    ArrayList<PlayCard> createDeck();
    
    void createAllOne();
    
    void createAllTwo();
    
    void createAllThree();
    
    void createAllFour();
    
    void createAllFive();
    
    void createAllSix();
    
    void createAllSeven();
    
    void createAllTen();
    
    void createAllEleven();
    
    void createAllTwelve();
    
    ArrayList<PlayCard> createFromTrama(String s);
}
