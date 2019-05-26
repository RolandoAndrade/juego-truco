import Models.Game.PlayGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GameGraphicManager extends JPanel implements GameGraphicControl
{
    public Board board;
    public PlayGame gameRoom;
    
    public GameGraphicManager(PlayGame gameRoom)
    {
        this.board=new Board();
        this.gameRoom=gameRoom;
        this.setBackground(new Color(33,33,33));
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        board.paint(g,this);
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
    
    }
}
