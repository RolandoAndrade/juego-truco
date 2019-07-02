package UIElements;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Button implements Clickeable,Drawable
{
    private static final int WIDTH = 80;
    private static final int HEIGHT = 30;
    private static final int HOVER_WIDTH = 83;
    private static final int HOVER_HEIGHT = 33;
    private int x,y,w,h;
    private Image image;
    public Button(int x, int y, String name)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.image=toolkit.getImage(ClassLoader.getSystemResource("buttons/"+name+".png"));
        setPosition(x,y);
        this.w=WIDTH;
        this.h=HEIGHT;
    }
    
    @Override
    public boolean onClick(int x, int y)
    {
        return x>this.x&&x<this.x+this.w&&y>this.y&&y<this.y+this.h;
    }
    
    @Override
    public boolean hover(int x, int y)
    {
        if(x>this.x&&x<this.x+this.w&&y>this.y&&y<this.y+this.h)
        {
            this.w=HOVER_WIDTH;
            this.h=HOVER_HEIGHT;
            return true;
        }
        this.w=WIDTH;
        this.h=HEIGHT;
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
