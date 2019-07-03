import Components.GraphicHand;
import Components.GraphicPlayer;
import GameManager.GameGraphicManager;
import GameManager.GameManager;
import GameManager.GraphicGameRoom;
import Models.Player.PlayPlayer;
import Serial.SerialManager;
import UIElements.Frame;
import UIElements.FrameControl;

import java.util.ArrayList;
import java.util.Collections;

public class UITest
{
    public static void main(String []args)
    {
        //Para saltar configuración de puertos, comentar línea de abajo
        SerialManager.start();
        GameManager.selectPlayer();
        SerialManager.handShake();
        ArrayList<PlayPlayer> players=new ArrayList<PlayPlayer>();
        Collections.addAll(players,
                new GraphicPlayer(0,"ROLANDO", new GraphicHand()),
                new GraphicPlayer(1,"JOSÉ", new GraphicHand()),
                new GraphicPlayer(2,"ÓSCAR", new GraphicHand()),
                new GraphicPlayer(3,"INVITADO", new GraphicHand()));
        FrameControl f=new Frame(new GameGraphicManager(new GraphicGameRoom(players)));
    }
}
