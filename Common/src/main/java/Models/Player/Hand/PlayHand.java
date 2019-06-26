package Models.Player.Hand;

import Models.Card.PlayCard;

import java.util.ArrayList;

public interface PlayHand
{
    void addCard(PlayCard card);
    void setCardList(ArrayList<PlayCard> cardList);
    ArrayList<PlayCard> getCards();
    int howManyCardsAre();
    void putCard(int i);
    PlayCard getPlayedCard();
    void removePlayedCard();
    void searchForSpecial(PlayCard vira);
    void setNumber(int number);
    int getNumber();
}
