import java.awt.*;
import java.awt.image.ImageObserver;

public interface Paintable
{
    void paint(Graphics g, ImageObserver observer);
}
