package Models.Deck;

import Exceptions.DeckEmptyException;
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
    public PlayCard pickCard() throws DeckEmptyException
    {
        int last = this.cards.size()-1;
        try
        {
            PlayCard card = this.cards.get(last);
            this.cards.remove(last);
            return card;
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new DeckEmptyException();
        }
    }
    
    @Override
    public void setCards(ArrayList<PlayCard> cards)
    {
        this.cards = cards;
    }
    
    @Override
    public void remove(int i)
    {
        this.cards.remove(i);
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
    
    @Override
    public String toString()
    {
        String s="Deck:\n";
        for(PlayCard card:this.cards)
            s+=card.toString()+"\n";
        s+="\n";
        return s;
    }
}
