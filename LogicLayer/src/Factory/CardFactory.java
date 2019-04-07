package Factory;


import Models.Card.ICard;

import java.util.ArrayList;

public abstract class CardFactory implements ICardFactory{
    public ArrayList<ICard> cardList;

    public CardFactory(ArrayList<ICard> cardList) {
        this.cardList = new ArrayList<ICard>();
    }

    public void crearTodos() {
        this.cardList.add(crearUno());
        this.cardList.add(crearDos());
        this.cardList.add(crearTres());
        this.cardList.add(crearCuatro());
        this.cardList.add(crearCinco());
        this.cardList.add(crearSeis());
        this.cardList.add(crearSiete());
        this.cardList.add(crearDiez());
        this.cardList.add(crearOnce());
        this.cardList.add(crearDoce());
    }

    @Override
    public String toString() {
        return "CardFactory{" +
                "cardList=" + cardList +
                '}';
    }
}
