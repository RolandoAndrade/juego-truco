package Models.Deck;

import Models.Card.PlayCard;

import java.util.ArrayList;

public interface PlayDeck
{
    void addPlayCard(PlayCard playCard);
    
    void setPlayCards(ArrayList<PlayCard> playCards);
    
    ArrayList<PlayCard> getPlayCards();
}
