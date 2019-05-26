import Command.Command;
import Models.Game.PlayGame;
import Command.FillDeskCommand;
import Command.DistributeCardsCommand;
import javax.swing.*;
import java.awt.*;

public class GameGraphicManager extends JPanel implements GameGraphicControl
{
    private PlayGame gameRoom;
    private Command fillDeck;
    private Command distribute;
    
    public GameGraphicManager(PlayGame gameRoom)
    {
        this.gameRoom=gameRoom;
        this.setBackground(new Color(33,33,33));
        fillDeck=new FillDeskCommand(gameRoom.getDeck());
        distribute=new DistributeCardsCommand(gameRoom);
        setUp();
    }
    
    private void distribute()
    {
        try
        {
            distribute.execute();
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
    }
}
