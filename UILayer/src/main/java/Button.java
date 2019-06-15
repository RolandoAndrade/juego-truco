import java.awt.*;
import java.awt.image.ImageObserver;

public class Button implements Clickeable,Drawable
{
    private static final int WIDTH = 80;
    private static final int HEIGHT = 30;
    private int x,y,w,h;
    private Image image;
    public Button(int x, int y, String name)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage("UILayer/src/main/resources/buttons/"+name+".png");
        setPosition(x,y);
        this.w=WIDTH;
        this.h=HEIGHT;
    }
    
    @Override
    public boolean onClick(int x, int y)
    {
        return false;
    }
    
    @Override
    public boolean hover(int x, int y)
    {
        return false;
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
        return x;
    }
    
    @Override
    public int getY()
    {
        return y;
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        g.drawImage(this.image,this.x,this.y,this.w,this.h,observer);
    }
}
