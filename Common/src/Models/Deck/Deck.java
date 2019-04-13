package Models.Deck;

import Models.Card.PlayCard;

import java.util.ArrayList;
import java.util.Collections;

public class Deck implements PlayDeck
{
    private ArrayList<PlayCard> cards;
    
    public Deck()
    {
        this.cards = new ArrayList<PlayCard>();
    }

    @Override
    public ArrayList<PlayCard> getCards()
    {
        return cards;
    }
    
    @Override
    public void setCards(ArrayList<PlayCard> cards)
    {
        this.cards = cards;
    }
    
    @Override
    public void addPlayCard(PlayCard playCard)
    {
        this.cards.add(playCard);
    }
    
    @Override
    public void mix()
    {
        Collections.shuffle(cards);
    }
}
