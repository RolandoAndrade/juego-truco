import Models.Game.GameRoom;
import Models.Player.PlayPlayer;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class GraphicGameRoom extends GameRoom implements Paintable
{
    public GraphicGameRoom(ArrayList<PlayPlayer> players)
    {
        super(players);
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        for(PlayPlayer player:getPlayers())
        {
            ((Drawable)player).paint(g,observer);
        }
    }
}
