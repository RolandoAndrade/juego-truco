import Command.Command;
import Command.FactoryCommand;
import Models.Game.GameRoom;
import Models.Game.PlayGame;
import Models.Player.PlayPlayer;
import Models.Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InitGameRoomCommandTest
{
    private PlayGame playGame;
    private ArrayList<PlayPlayer> players;
    private Command initGameRoomCommand;
    
    @BeforeEach
    void init(){
        initList();
        this.playGame = new GameRoom();
        this.playGame.setPlayers(players);
        initGameRoomCommand = FactoryCommand.createInitGameRoomCommand(this.playGame);
    }
    
    public void initList(){
        players = new ArrayList<PlayPlayer>();
        this.players.add(new Player("Jose"));
        this.players.add(new Player("Manuel"));
        this.players.add(new Player("Omar"));
        this.players.add(new Player("Ramiro"));
    }
    @Test
    void execute()
    {
        try
        {
            initGameRoomCommand.execute();
            assertNotNull(playGame.getDeck().getCards().get(1));
            assertNotNull(playGame.getPlayers().get(1));
            assertEquals("jose",playGame.getPlayer(0).getName().toLowerCase());
            assertNotNull(playGame.getPlayer(0).getHand());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}