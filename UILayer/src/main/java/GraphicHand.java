import Models.Card.PlayCard;
import Models.Player.Hand.Hand;
import Models.Player.Hand.PlayHand;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicHand extends Hand implements Drawable
{
    private int x,y;
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        for(PlayCard card:getCardList())
        {
            try
            {
                ((Drawable) card).paint(g, observer);
            }
            catch (Exception e)
            {
                System.err.println("Error, esta carta no se puede dibujar");
            }
        }
    }
    
    @Override
    public void setPosition(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    @Override
    public int getX()
    {
        return this.x;
    }
    
    @Override
    public int getY()
    {
        return this.y;
    }
}
