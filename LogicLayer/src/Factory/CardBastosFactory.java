package Factory;

import Models.Card.CardBastos;
import Models.Card.ICard;

import java.util.ArrayList;


public class CardBastosFactory extends CardFactory {

    public CardBastosFactory(ArrayList<ICard> cardList) {
        super(cardList);
    }

    @Override
    public void crearTodos() {
        super.crearTodos();
    }

    public ICard crearUno() {
        return new CardBastos(1, "rutaImg", false, false);
    }

    public ICard crearDos() {
        return new CardBastos(2, "rutaImg", false, false);
    }

    public ICard crearTres() {
        return new CardBastos(3, "rutaImg", false, false);
    }

    public ICard crearCuatro() {
        return new CardBastos(4, "rutaImg", false, false);
    }

    public ICard crearCinco() {
        return new CardBastos(5, "rutaImg", false, false);
    }

    public ICard crearSeis() {
        return new CardBastos(6, "rutaImg", false, false);
    }

    public ICard crearSiete() {
        return new CardBastos(7, "rutaImg", false, false);
    }

    public ICard crearDiez() {
        return new CardBastos(10, "rutaImg", false, false);
    }

    public ICard crearOnce() {
        return new CardBastos(11, "rutaImg", false, false);
    }

    public ICard crearDoce() {
        return new CardBastos(12, "rutaImg", false, false);
    }


}
