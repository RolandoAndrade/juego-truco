import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements FrameControl
{
    private static final int FRAME_HEIGHT = 500;
    
    private static final int FRAME_WIDTH = 700;
    
    private static final String ICON_PATH="UILayer/src/main/resources/sword/12.jpeg";

    
    public Frame()
    {
        createFrame();
    }
    
    private void createFrame()
    {
        this.setTitle("Truco");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**Creamos un toolkit para usar la posición relativa de un archivo dentro del módulo*/
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Image icon=toolkit.getImage(ICON_PATH);
        this.setIconImage(icon);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        Board b=new Board();
        this.add(b);
        addMouseListener(new MouseClick(this,(Clickeable)b.getPlayer()));
        this.setVisible(true);
    }
    
    @Override
    public void update()
    {
        this.repaint();
    }
}
