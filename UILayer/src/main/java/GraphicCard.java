import Models.Card.Card;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicCard implements Drawable
{
    private static final int WIDTH = 60;
    private static final int HEIGHT = 100;
    private Card card;
    private Image image;
    private int x,y,w,h;
    
    public GraphicCard(Card card, int x, int y, boolean front)
    {
        this.card = card;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage("UILayer/src/main/resources/"+card.getImagePath());
        this.x=x;
        this.y=y;
        this.w=WIDTH;
        this.h=HEIGHT;
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        g.drawImage(this.image,this.x,this.y,this.w,this.h,observer);
    }
}
