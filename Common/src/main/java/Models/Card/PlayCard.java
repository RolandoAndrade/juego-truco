package Models.Card;

import Services.Strategies.Cards.PlayCardStrategy;

public interface PlayCard
{
    String getImagePath();
    int getNumber();
    PlayCardStrategy getStrategy();
    void setStrategy(PlayCardStrategy strategy);
    String getColor();
    int getPoints();
    boolean isSameColor(PlayCard card);
    String getTypeOfCard(); 
}
