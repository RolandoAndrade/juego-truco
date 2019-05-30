import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseClick extends MouseAdapter
{
    private ArrayList<Clickeable> clickeables;
    private FrameControl frameControl;
    private static final int OFFSET=25;
    
    public MouseClick(FrameControl frameControl, GameGraphicControl control)
    {
        this.clickeables=control.getClickeables();
        this.frameControl=frameControl;
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
        for(Clickeable c:clickeables)
        {
            if(c.onClick(e.getX(),e.getY()-OFFSET))
                this.frameControl.update();
        }
    }
}
