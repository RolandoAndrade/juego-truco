package Services.Strategies.Cards;

import Services.Strategies.GameStates.GameState;

public interface PlayCardStrategy
{
    public int getValue();
    public GameState play(PlayCardStrategy rival);
}
