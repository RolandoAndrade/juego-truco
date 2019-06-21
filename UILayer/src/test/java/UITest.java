import Models.Game.GameRoom;
import Models.Player.PlayPlayer;

import java.util.ArrayList;
import java.util.Collections;

public class UITest
{
    public static void main(String []args)
    {
        ArrayList<PlayPlayer> players=new ArrayList<PlayPlayer>();
        Collections.addAll(players,
                new GraphicPlayer(0,"ROLANDO", new GraphicHand()),
                new GraphicPlayer(1,"JOSÉ", new GraphicHand()),
                new GraphicPlayer(2,"ÓSCAR", new GraphicHand()),
                new GraphicPlayer(3,"INVITADO", new GraphicHand()));
        FrameControl f=new Frame(new GameGraphicManager(new GraphicGameRoom(players)));
    }
}
