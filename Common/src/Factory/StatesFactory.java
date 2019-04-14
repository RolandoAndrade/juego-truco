package Factory;

import Services.Strategies.GameStates.Draw;
import Services.Strategies.GameStates.GameState;
import Services.Strategies.GameStates.Lose;
import Services.Strategies.GameStates.Win;

public class StatesFactory implements CreateState
{
    @Override
    public GameState create(int pointsCard1, int pointsCard2)
    {
        if(pointsCard1>pointsCard2)
        {
            return new Win();
        }
        else if(pointsCard1<pointsCard2)
        {
            return new Lose();
        }
        return new Draw();
    }
}
