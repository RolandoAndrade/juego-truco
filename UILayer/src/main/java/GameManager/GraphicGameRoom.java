package GameManager;

import Components.GraphicCard;
import Models.Card.PlayCard;
import Models.Game.GameRoom;
import Models.Player.PlayPlayer;
import UIElements.Drawable;
import UIElements.Paintable;
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
    public void putVira()
    {
        try
        {
            PlayCard card = getDeck().pickCard();
            setVira(card);
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
    
    @Override
    public void setVira(PlayCard vira)
    {
        super.setVira(new GraphicCard(vira,320,200,true));
        for (PlayPlayer p: getPlayers())
        {
            p.getHand().searchForSpecial(getVira());
        }
    }
}
