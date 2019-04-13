package Models.Deck;

import Models.Card.PlayCard;

import java.util.ArrayList;

public interface PlayDeck
{
    void addPlayCard(PlayCard playCard);
    
    void setCards(ArrayList<PlayCard> cards);
    
    void mix();
    
    ArrayList<PlayCard> getCards();
}
