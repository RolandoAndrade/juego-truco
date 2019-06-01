import Command.Command;
import Models.Game.PlayGame;
import Command.FillDeskCommand;
import Command.DistributeCardsCommand;
import Models.Player.PlayPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGraphicManager extends JPanel implements GameGraphicControl
{
    private PlayGame gameRoom;
    private Command fillDeck;
    private Command distribute;
    private Button button;
    
    public GameGraphicManager(PlayGame gameRoom)
    {
        this.gameRoom=gameRoom;
        this.setBackground(new Color(33,33,33));
        fillDeck=new FillDeskCommand(gameRoom.getDeck());
        distribute=new DistributeCardsCommand(gameRoom);
        button=new Button(310,430,"truco");
        setUp();
    }
    
    private void distribute()
    {
        try
        {
            distribute.execute();
            gameRoom.putVira();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    private void setUp()
    {
        try
        {
            fillDeck.execute();
            this.distribute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        ((Paintable)gameRoom).paint(g,this);
        ((Paintable)button).paint(g,this);
    }
    
    @Override
    public ArrayList<Clickeable> getClickeables()
    {
        ArrayList<Clickeable> c=new ArrayList<>();
        for(PlayPlayer player:gameRoom.getPlayers())
        {
            c.add((Clickeable)player);
        }
        return c;
    }
}
