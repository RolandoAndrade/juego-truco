package Services.Strategies.GameStates;

public class Lose implements GameState
{
    
    @Override
    public int compare(GameState buddy)
    {
        if(buddy instanceof Win)
        {
            return 1;
        }
        return 0;
    }
}
