package Models.Deck;

import Models.Card.PlayCard;

import java.util.ArrayList;

public class Deck implements PlayDeck
{
    ArrayList<PlayCard> playCards;
    
    public Deck()
    {
        this.playCards = new ArrayList<PlayCard>();
    }

    public ArrayList<PlayCard> getPlayCards()
    {
        return playCards;
    }
    
    public void setPlayCards(ArrayList<PlayCard> playCards)
    {
        this.playCards = playCards;
    }
    
    public void addPlayCard(PlayCard playCard)
    {
        this.playCards.add(playCard);
    }
}
