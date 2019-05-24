import Models.Player.PlayPlayer;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicPlayer implements Drawable
{
    private PlayPlayer player;
    public GraphicPlayer(PlayPlayer player)
    {
        this.player = player;
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        try
        {
            ((Drawable)player.getHand()).paint(g,observer);
        }
        catch (Exception e)
        {
            System.err.println("Esta mano no se puede dibujar");
        }
    }
}
