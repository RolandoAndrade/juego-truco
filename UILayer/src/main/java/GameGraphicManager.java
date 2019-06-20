import Command.Command;
import Models.Game.PlayGame;
import Command.InitGameRoomCommand;
import Models.Player.PlayPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGraphicManager extends JPanel implements GameGraphicControl
{
    private PlayGame gameRoom;
    private Command init;
    private Button button;
    
    public GameGraphicManager(PlayGame gameRoom)
    {
        this.gameRoom=gameRoom;
        this.setBackground(new Color(33,33,33));
        init=new InitGameRoomCommand(gameRoom);
        button=new Button(310,430,"truco");
        GameManager.setFill(init);
        GameManager.setGameRoom(gameRoom);
        setUp();
    }
    
    private void setUp()
    {
        try
        {
            init.execute();
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
