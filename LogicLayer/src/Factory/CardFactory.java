package Factory;

import Models.Card.One;
import Models.Card.PlayCard;
import Models.Card.Two;

public class CardFactory implements CreateCard
{
    @Override
    public PlayCard createOne(String type)
    {
        if (type.toLowerCase().equals("sword"))
        {
            return new One(1, type);
        }
        if (type.toLowerCase().equals("gold"))
        {
            return new One(1, type);
        }
        if (type.toLowerCase().equals("cup"))
        {
            return new One(1, type);
        }
        if (type.toLowerCase().equals("bastos"))
        {
            return new One(1, type);
        }
        return null;
    }
    
    @Override
    public PlayCard createTwo(String type)
    {
        if (type.toLowerCase().equals("sword"))
        {
            return new Two(2, type);
        }
        if (type.toLowerCase().equals("gold"))
        {
            return new Two(2, type);
        }
        if (type.toLowerCase().equals("cup"))
        {
            return new Two(2, type);
        }
        if (type.toLowerCase().equals("bastos"))
        {
            return new Two(2, type);
        }
        return null;
    }
    
    @Override
    public PlayCard createThree(String type)
    {
        return null;
    }
    
    @Override
    public PlayCard createFour(String type)
    {
        return null;
    }
    
    @Override
    public PlayCard createFive(String type)
    {
        return null;
    }
    
    @Override
    public PlayCard createSix(String type)
    {
        return null;
    }
    
    @Override
    public PlayCard createSeven(String type)
    {
        return null;
    }
    
    @Override
    public PlayCard createTen(String type)
    {
        return null;
    }
    
    @Override
    public PlayCard createEleven(String type)
    {
        return null;
    }
    
    @Override
    public PlayCard createTwelve(String type)
    {
        return null;
    }
}
