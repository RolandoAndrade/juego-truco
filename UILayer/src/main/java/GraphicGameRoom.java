import Models.Card.PlayCard;
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
        GameManager.setPlayers(players);
    }
    
    @Override
    public void putVira()
    {
        try
        {
            PlayCard card = getDeck().pickCard();
            setVira(new GraphicCard(card,320,200,true));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        for(PlayPlayer player:getPlayers())
        {
            ((Drawable)player).paint(g,observer);
        }
        ((Drawable)getVira()).paint(g,observer);
    }
}
