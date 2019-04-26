import Models.Card.Card;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicCard implements Drawable
{
    private Card card;
    private Image image;
    private int x,y,w,h;
    
    public GraphicCard(Card card, boolean front)
    {
        this.card = card;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage("UILayer/src/main/resources/"+card.getImagePath());
        System.out.println(card.getImagePath());
        this.x=0;
        this.y=0;
        this.w=80;
        this.h=100;
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        g.drawImage(this.image,this.x,this.y,this.w,this.h,observer);
    }
}
