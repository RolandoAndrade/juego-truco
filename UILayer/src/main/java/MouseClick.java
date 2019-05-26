import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MouseClick extends MouseAdapter
{
    private ArrayList<Clickeable> clickeables;
    private FrameControl frameControl;
    
    public MouseClick(FrameControl frameControl, GameGraphicControl control)
    {
        this.clickeables=control.getClickeables();
        this.frameControl=frameControl;
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println(e.getX()+", "+e.getY());
        for(Clickeable c:clickeables)
        {
            if(c.onClick(e.getX(),e.getY()))
                this.frameControl.update();
        }
    }
}
