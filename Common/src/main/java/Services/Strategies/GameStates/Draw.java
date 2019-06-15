package Services.Strategies.GameStates;

public class Draw implements GameState
{
    @Override
    public int compare(GameState buddy)
    {
        if (buddy instanceof Win)
        {
            return 1;
        }
        else if(buddy instanceof Draw)
        {
            return 0;
        }
        return 2;
    }
}
