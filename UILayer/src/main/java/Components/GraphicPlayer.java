package Components;

import GameManager.GameManager;
import Models.Card.PlayCard;
import Models.Player.Hand.PlayHand;
import Models.Player.Player;
import Serial.SerialManager;
import UIElements.Clickeable;
import UIElements.Drawable;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicPlayer extends Player implements Drawable, Clickeable
{
    private int number, x,y;
    private static final int FONT_SIZE=15;
    public GraphicPlayer(int number, String name, PlayHand hand)
    {
        super(name, hand);
        getHand().setNumber(number);
        this.number = number;
        int len = name.length();
        setLocation(len);
    }
    
    private void setLocation(int len)
    {
        switch (this.number)
        {
            case 0:
                this.setPosition(15,460);
                ((Drawable)getHand()).setPosition(20,320);
                break;
            case 1:
                this.setPosition(685-20*(len)+(len-1)*10,460);
                ((Drawable)getHand()).setPosition(485,320);
                break;
            case 2:
                this.setPosition(685-20*(len)+(len-1)*10,25);
                ((Drawable)getHand()).setPosition(485,50);
                break;
            case 3:
                this.setPosition(15,25);
                ((Drawable)getHand()).setPosition(20,50);
                break;
        }
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        g.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        if (GameManager.isMyTurn(this.number))
            g.setColor(Color.CYAN);
        else
            g.setColor(Color.GRAY);
        g.drawString(getName(),this.x,this.y);
        try
        {
            ((Drawable)getHand()).paint(g,observer);
        }
        catch (Exception e)
        {
            System.err.println("Esta mano no se puede dibujar");
        }
    }
    
    @Override
    public void setPosition(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    @Override
    public void giveCard(PlayCard card)
    {
        //super.giveCard(new Components.GraphicCard(card,0,0,this.number==0));
        super.giveCard(new GraphicCard(card,0,0,GameManager.TESTING||this.number==GameManager.getPLAYER()));
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
        if((GameManager.TESTING||(this.number==GameManager.getPLAYER())&&GameManager.isMyTurn(this.number)))
        {
            if(((Clickeable)getHand()).onClick(x,y))
            {
                SerialManager.playCard(getHand().getPlayedCard(),this.number);
                GameManager.finishMyTurn(getHand().getPlayedCard());
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean hover(int x, int y)
    {
        if(((Clickeable)getHand()).hover(x,y))
        {
            return true;
        }
        return false;
    }
}
