package Components;

import Models.Card.Card;
import Models.Card.PlayCard;
import UIElements.Clickeable;
import UIElements.Drawable;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.net.URL;

public class GraphicCard extends Card implements Drawable, Clickeable
{
    private static final int WIDTH = 60;
    private static final int HEIGHT = 100;
    private static final int HOVER_WIDTH = 62;
    private static final int HOVER_HEIGHT = 102;
    private static final URL BACK_IMAGE_PATH=ClassLoader.getSystemResource("back.png");
    private static Image BACK_IMAGE;
    private Image image;
    private int x,y,w,h;
    private boolean front;
    
    
    public GraphicCard(PlayCard card, int x, int y, boolean front)
    {
        super(card.getNumber(),card.getColor(),card.getStrategy());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage(ClassLoader.getSystemResource(getImagePath()));
        BACK_IMAGE=toolkit.getImage(BACK_IMAGE_PATH);
        setPosition(x,y);
        this.w=WIDTH;
        this.h=HEIGHT;
        this.front=front;
    }
    
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        if(this.front)
        {
            g.drawImage(this.image,this.x,this.y,this.w,this.h,observer);
        }
        else
        {
            g.drawImage(BACK_IMAGE,this.x,this.y,this.w,this.h,observer);
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
    
    @Override
    public boolean onClick(int x, int y)
    {
        return x>this.x&&x<this.x+this.w&&y>this.y&&y<this.y+this.h;
    }
    
    @Override
    public boolean hover(int x, int y)
    {
        if(onClick(x,y))
        {
            this.w=HOVER_WIDTH;
            this.h=HOVER_HEIGHT;
            return true;
        }
        this.w=WIDTH;
        this.h=HEIGHT;
        return false;
    }
}
