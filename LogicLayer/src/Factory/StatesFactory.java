package Factory;

import Startegies.GameStates.Draw;
import Startegies.GameStates.GameState;
import Startegies.GameStates.Lose;
import Startegies.GameStates.Win;

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
