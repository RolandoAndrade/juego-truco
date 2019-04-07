package Models.Deck;

import Models.Card.ICard;

import java.util.ArrayList;

public class Deck {
    private ArrayList<ICard> cards;

    public Deck(ArrayList<ICard> cards) {
        this.cards = new ArrayList<>(); //debe llenarse con todas las cartas
    }
}
