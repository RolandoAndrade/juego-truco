package Factory;

import Models.Card.CardBastos;
import Models.Card.CardSword;
import Models.Card.ICard;

import java.util.ArrayList;


public class CardSwordFactory extends CardFactory {

    public CardSwordFactory(ArrayList<ICard> cardList) {
        super(cardList);
    }

    public ICard crearUno() {
        return new CardSword(1, "rutaImg", false, false);
    }

    public ICard crearDos() {
        return new CardSword(2, "rutaImg", false, false);
    }

    public ICard crearTres() {
        return new CardSword(3, "rutaImg", false, false);
    }

    public ICard crearCuatro() {
        return new CardSword(4, "rutaImg", false, false);
    }

    public ICard crearCinco() {
        return new CardSword(5, "rutaImg", false, false);
    }

    public ICard crearSeis() {
        return new CardSword(6, "rutaImg", false, false);
    }

    public ICard crearSiete() {
        return new CardSword(7, "rutaImg", false, false);
    }

    public ICard crearDiez() {
        return new CardSword(8, "rutaImg", false, false);
    }

    public ICard crearOnce() {
        return new CardSword(9, "rutaImg", false, false);
    }

    public ICard crearDoce() {
        return new CardSword(10, "rutaImg", false, false);
    }
}
