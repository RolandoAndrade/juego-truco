package Services.Strategies.GameStates;

public class Win implements GameState
{
    
    @Override
    public int compare(GameState buddy)
    {
        return 1;
    }
}
