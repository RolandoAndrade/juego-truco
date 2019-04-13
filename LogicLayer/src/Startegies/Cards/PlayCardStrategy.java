package Startegies.Cards;

import Startegies.GameStates.GameState;

public interface PlayCardStrategy
{
    public int getValue();
    public GameState play(PlayCardStrategy rival);
}
