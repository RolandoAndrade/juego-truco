package Startegies.Cards;

import Factory.StatesFactory;
import Startegies.GameStates.GameState;

public abstract class CardStrategy implements PlayCardStrategy
{
    @Override
    public GameState play(PlayCardStrategy rival)
    {
        return new StatesFactory().create(getValue(),rival.getValue());
    }
}
