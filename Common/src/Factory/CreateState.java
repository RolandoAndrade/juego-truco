package Factory;

import Services.Strategies.GameStates.GameState;

public interface CreateState
{
    public GameState create(int pointsCard1, int pointsCard2);
}
