package Factory;

import Models.Card.CardCup;
import Models.Card.ICard;

import java.util.ArrayList;

public class CardCupFactory extends CardFactory {

    public CardCupFactory(ArrayList<ICard> cardList) {
        super(cardList);
    }


    public ICard crearUno() {
        return new CardCup(1, "rutaImg", false, false);
    }

    public ICard crearDos() {
        return new CardCup(2, "rutaImg", false, false);
    }

    public ICard crearTres() {
        return new CardCup(3, "rutaImg", false, false);
    }

    public ICard crearCuatro() {
        return new CardCup(4, "rutaImg", false, false);
    }

    public ICard crearCinco() {
        return new CardCup(5, "rutaImg", false, false);
    }

    public ICard crearSeis() {
        return new CardCup(6, "rutaImg", false, false);
    }

    public ICard crearSiete() {
        return new CardCup(7, "rutaImg", false, false);
    }

    public ICard crearDiez() {
        return new CardCup(10, "rutaImg", false, false);
    }

    public ICard crearOnce() {
        return new CardCup(11, "rutaImg", false, false);
    }

    public ICard crearDoce() {
        return new CardCup(12, "rutaImg", false, false);
    }
}
