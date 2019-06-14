package Models.Card;

import Services.Strategies.Cards.PlayCardStrategy;
import Services.Strategies.GameStates.GameState;

public interface PlayCard
{
    String getImagePath();
    int getNumber();
    PlayCardStrategy getStrategy();
    String getColor();
    GameState play(PlayCard card);
}
