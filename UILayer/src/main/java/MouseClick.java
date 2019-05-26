import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter
{
    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println(e.getSource());
    }
}
