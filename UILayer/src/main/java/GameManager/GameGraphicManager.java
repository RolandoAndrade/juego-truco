package GameManager;

import Command.Command;
import Models.Game.PlayGame;
import Command.InitGameRoomCommand;
import Models.Player.PlayPlayer;
import Serial.SerialManager;
import UIElements.*;
import UIElements.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGraphicManager extends JPanel implements GameGraphicControl
{
    private PlayGame gameRoom;
    private Command init;
    private Button button;
    private GraphicScore score;
    
    public GameGraphicManager(PlayGame gameRoom)
    {
        this.gameRoom=gameRoom;
        this.setBackground(new Color(33,33,33));
        init=new InitGameRoomCommand(gameRoom);
        button=new TrickButton(310,430,"truco");
        score=new GraphicScore();
        GameManager.setFill(init);
        GameManager.setGameRoom(gameRoom);
        GameManager.setScore(score);
        //setUp();
    }
    
    @Override
    public void paint(Graphics g)
    {
        try
        {
            super.paint(g);
            ((Paintable)gameRoom).paint(g,this);
            ((Paintable)button).paint(g,this);
            ((Paintable)score).paint(g,this);
        }
        catch (Exception e)
        {
            System.out.println("Todavía no se puede jugar");
        }
        
    }
    
    @Override
    public ArrayList<Clickeable> getClickeables()
    {
        ArrayList<Clickeable> c=new ArrayList<>();
        for(PlayPlayer player:gameRoom.getPlayers())
        {
            c.add((Clickeable)player);
        }
        c.add(button);
        return c;
    }
}
