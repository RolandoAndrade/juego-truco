import Models.Card.Card;
import Models.Card.PlayCard;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicCard extends Card implements Drawable
{
    private static final int WIDTH = 60;
    private static final int HEIGHT = 100;
    private static final String BACK_IMAGE_PATH="UILayer/src/main/resources/back.png";
    private static Image BACK_IMAGE;
    private Image image;
    private int x,y,w,h;
    private boolean front;
    
    
    private String imagePath;
    
    public GraphicCard(int number, String imagePath, int x, int y, boolean front)
    {
        super(number, imagePath);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage("UILayer/src/main/resources/"+getImagePath());
        BACK_IMAGE=toolkit.getImage(BACK_IMAGE_PATH);
        this.x=x;
        this.y=y;
        this.w=WIDTH;
        this.h=HEIGHT;
        this.front=front;
    }
    
    public GraphicCard(PlayCard card, int x, int y, boolean front)
    {
        super(card.getNumber(),card.getColor(),card.getStrategy());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage("UILayer/src/main/resources/"+getImagePath());
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
