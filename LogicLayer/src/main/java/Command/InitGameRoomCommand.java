package Command;

import Models.Game.GameRoom;
import Models.Game.PlayGame;
import Models.Player.PlayPlayer;

import java.util.ArrayList;

public class InitGameRoomCommand extends Command
{
    PlayGame gameRoom;
    ArrayList<Command> commands;
    
    public InitGameRoomCommand(PlayGame playGame)
    {
        this.gameRoom = playGame;
        this.commands = new ArrayList<Command>();
        this.commands.add(FactoryCommand.
                        createFillDeskCommand(gameRoom.getDeck()));
        this.commands.add(FactoryCommand.
                createDistributeCardsCommand(gameRoom));
    }
    
    @Override
    public void execute() throws Exception
    {
        for (Command command : commands)
        {
            command.execute();
        }
    }
    
    @Override
    public Object Return()
    {
        return null;
    }
}
