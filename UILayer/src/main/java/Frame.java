import javax.swing.*;
import java.awt.*;

public class Frame implements FrameControl
{
    private static final int FRAME_HEIGHT = 500;
    
    private static final int FRAME_WIDTH = 700;
    
    private static final String ICON_PATH="UILayer/src/main/resources/sword/12.jpeg";
    
    private JFrame frame;
    
    public Frame()
    {
        createFrame();
    }
    
    private void createFrame()
    {
        this.frame=new JFrame();
        this.frame.setTitle("Truco");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**Creamos un toolkit para usar la posición relativa de un archivo dentro del módulo*/
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Image icon=toolkit.getImage(ICON_PATH);
        this.frame.setIconImage(icon);
        this.frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        
        
        
        this.frame.setLocationRelativeTo(null);
        this.frame.add(new Board());
        this.frame.setVisible(true);
    }
    
    
    @Override
    public void show()
    {
        this.frame.setVisible(true);
    }
    
    @Override
    public void hide()
    {
        this.frame.setVisible(true);
    }
}
