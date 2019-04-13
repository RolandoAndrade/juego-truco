package Factory;

import Models.Card.PlayCard;

public interface CreateCard
{
    PlayCard createOne(String type);
    
    PlayCard createTwo(String type);
    
    PlayCard createThree(String type);
    
    PlayCard createFour(String type);
    
    PlayCard createFive(String type);
    
    PlayCard createSix(String type);
    
    PlayCard createSeven(String type);
    
    PlayCard createTen(String type);
    
    PlayCard createEleven(String type);
    
    PlayCard createTwelve(String type);
}
