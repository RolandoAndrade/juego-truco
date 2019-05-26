package Models.Card;

import Services.Strategies.Cards.PlayCardStrategy;

public interface PlayCard
{
    String getImagePath();
    int getNumber();
    PlayCardStrategy getStrategy();
    String getColor();
}
