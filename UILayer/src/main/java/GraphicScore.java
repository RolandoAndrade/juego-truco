import Models.Score.Score;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicScore extends Score implements Paintable
{
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        g.setColor(Color.GRAY);
        g.drawString("EQUIPO A    "+(getTeamAScore()>9?getTeamAScore():"0"+getTeamAScore())+
                "  -  "+(getTeamBScore()>9?getTeamBScore():"0"+getTeamBScore())+"    EQUIPO B",235,30);
    }
}
