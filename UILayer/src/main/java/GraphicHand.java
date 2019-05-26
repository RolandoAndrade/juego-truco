import Models.Card.PlayCard;
import Models.Player.Hand.Hand;
import Models.Player.Hand.PlayHand;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicHand extends Hand implements Drawable, Clickeable
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
    public void addCard(PlayCard card)
    {
        ((Drawable)card).setPosition(65*howManyCardsAre()+this.x,this.y);
        super.addCard(card);
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
    
    @Override
    public boolean onClick(int x, int y)
    {
        if(x>this.x&&y>this.y&&x<this.x+65*3&&y<this.y+100)
        {
            for(int i=0;i<howManyCardsAre();i++)
            {
                if(((Clickeable)getCardList().get(i)).onClick(x,y))
                {
                    putCard(i);
                    return true;
                }
            }
        }
        return false;
    }
}
