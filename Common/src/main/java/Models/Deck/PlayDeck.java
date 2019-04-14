package Models.Deck;

import Exceptions.DeckEmptyException;
import Models.Card.PlayCard;

import java.util.ArrayList;

public interface PlayDeck
{
    void addPlayCard(PlayCard playCard);
    
    void setCards(ArrayList<PlayCard> cards);
    
    void remove(int i);
    
    void mix();
    
    ArrayList<PlayCard> getCards();
    
    PlayCard pickCard()throws DeckEmptyException;
}
