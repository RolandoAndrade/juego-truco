import Models.Card.PlayCard;
import Models.Player.Hand.PlayHand;
import Models.Player.PlayPlayer;
import Models.Player.Player;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicPlayer extends Player implements Drawable
{
    private int number, x,y;
    private static final int FONT_SIZE=15;
    public GraphicPlayer(int number, String name, PlayHand hand)
    {
        super(name, hand);
        this.number = number;
        int len = name.length();
        switch (number)
        {
            case 0:
                this.x=10;
                this.y=460;
                break;
            case 1:
                this.x=690-20*(len)+(len-1)*10;
                this.y=460;
                break;
            case 2:
                this.x=690-20*(len)+(len-1)*10;
                this.y=25;
                break;
            case 3:
                this.x=10;
                this.y=25;
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
}
