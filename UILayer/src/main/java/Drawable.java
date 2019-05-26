import java.awt.*;
import java.awt.image.ImageObserver;

public interface Drawable
{
    void paint(Graphics g, ImageObserver observer);
    void setPosition(int x,int y);
    int getX();
    int getY();
}
