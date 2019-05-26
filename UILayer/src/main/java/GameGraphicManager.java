import Models.Game.PlayGame;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GameGraphicManager implements GameGraphicControl
{
    public Board board;
    public PlayGame gameRoom;
    
    public GameGraphicManager(PlayGame gameRoom)
    {
        this.board=new Board();
        this.gameRoom=gameRoom;
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        board.paint(g);
    }
}
