import Models.Card.Card;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicCard implements Drawable
{
    private static final int WIDTH = 60;
    private static final int HEIGHT = 100;
    private static final String BACK_IMAGE_PATH="UILayer/src/main/resources/back.png";
    private static Image BACK_IMAGE;
    private Card card;
    private Image image;
    private int x,y,w,h;
    private boolean front;
    
    public GraphicCard(Card card, int x, int y, boolean front)
    {
        this.card = card;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage("UILayer/src/main/resources/"+card.getImagePath());
        BACK_IMAGE=toolkit.getImage(BACK_IMAGE_PATH);
        this.x=x;
        this.y=y;
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
}
