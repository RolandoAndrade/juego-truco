package Components;

import GameManager.GameManager;
import Models.Card.PlayCard;
import Models.Player.Hand.Hand;
import UIElements.Clickeable;
import UIElements.Drawable;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class GraphicHand extends Hand implements Drawable, Clickeable
{
    private int x,y;
    private int zoneX, zoneY;
    
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
        try
        {
            ((Drawable) getPlayedCard()).paint(g, observer);
        }
        catch (Exception e)
        {
        
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
        this.zoneX=x<350?250:390;
        this.zoneY=y<250?130:250;
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
    public void putCard(int i)
    {
        ((Drawable)getCardList().get(i)).setPosition(this.zoneX,this.zoneY);
        super.putCard(i);
        moveCardsToLeft(i);
    }
    
    @Override
    public boolean onClick(int x, int y)
    {
        if(x>this.x&&y>this.y&&x<this.x+65*3&&y<this.y+100)
        {
            for(int i=0;i<howManyCardsAre();i++)
            {
                PlayCard card=getCardList().get(i);
                if(((Clickeable)card).onClick(x,y))
                {
                    putCard(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean hover(int x, int y)
    {
        if(x>this.x-20&&y>this.y-20&&x<this.x+65*3+20&&y<this.y+120)
        {
            for(int i=0;i<howManyCardsAre();i++)
            {
                PlayCard card=getCardList().get(i);
                if(((Clickeable)card).hover(x,y))
                {
                    return true;
                }
            }
            clean();
            return true;
        }
        return false;
    }
    
    private void clean()
    {
        for(int i=0;i<howManyCardsAre();i++)
        {
            PlayCard card=getCardList().get(i);
            ((Clickeable)card).hover(0,0);
        }
    }
    
    private void moveCardsToLeft(int i)
    {
        for (int j=i;j<howManyCardsAre();j++)
        {
            Drawable d=((Drawable)getCardList().get(j));
            d.setPosition(d.getX()-65,d.getY());
        }
        
    }
    
    @Override
    public void setCardList(ArrayList<PlayCard> cardList)
    {
        super.setCardList(new ArrayList<PlayCard>());
        for (PlayCard card: cardList)
            addCard(new GraphicCard(card,0,0,GameManager.getPLAYER()==getNumber()));
    }
}
