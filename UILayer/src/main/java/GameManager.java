import Models.Game.GameRoom;
import Models.Game.PlayGame;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class GameManager extends JPanel
{
    public Board board;
    public PlayGame gameRoom;
    
    public GameManager(PlayGame gameRoom)
    {
        this.board=new Board();
        add(this.board);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        board.paint(g);
    }
}
