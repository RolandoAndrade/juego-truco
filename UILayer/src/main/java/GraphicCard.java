import Models.Card.Card;

import java.awt.*;

public class GraphicCard implements Drawable
{
    private Card card;
    private Image image;
    private int x,y,w,h;
    
    public GraphicCard(Card card, boolean front)
    {
        this.card = card;
        /*Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage(c);*/
    }
    
    @Override
    public void paint(Graphics g)
    {
        //g.drawImage(this.image,)
    }
}
