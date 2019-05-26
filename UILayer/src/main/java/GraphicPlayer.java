import Models.Card.PlayCard;
import Models.Player.Hand.PlayHand;
import Models.Player.Player;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicPlayer extends Player implements Drawable, Clickeable
{
    private int number, x,y;
    private static final int FONT_SIZE=15;
    public GraphicPlayer(int number, String name, PlayHand hand)
    {
        super(name, hand);
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
        //super.giveCard(new GraphicCard(card,0,0,this.number==0));
        super.giveCard(new GraphicCard(card,0,0,true));
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
        if(this.number==0||true)
        {
            if(((Clickeable)getHand()).onClick(x,y))
            {
                System.out.println("Ok");
                return true;
            }
        }
        return false;
    }
}
