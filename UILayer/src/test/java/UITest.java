import Models.Player.PlayPlayer;
import Serial.SerialManager;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class UITest
{
    public static void main(String []args)
    {
        String options[]={"COM4","COM5"};
        String s=(String)JOptionPane.showInputDialog(new JFrame("NADA"),"Introduce el puerto",
                "Título", JOptionPane.QUESTION_MESSAGE,null,
                options,options[0]);
        SerialManager.start(s);
        ArrayList<PlayPlayer> players=new ArrayList<PlayPlayer>();
        Collections.addAll(players,
                new GraphicPlayer(0,"ROLANDO", new GraphicHand()),
                new GraphicPlayer(1,"JOSÉ", new GraphicHand()),
                new GraphicPlayer(2,"ÓSCAR", new GraphicHand()),
                new GraphicPlayer(3,"INVITADO", new GraphicHand()));
        FrameControl f=new Frame(new GameGraphicManager(new GraphicGameRoom(players)));
    }
}
