package Factory;

import Models.Card.CardGold;
import Models.Card.ICard;

import java.util.ArrayList;

public class CardGoldFactory extends CardFactory {

    public CardGoldFactory(ArrayList<ICard> cardList) {
        super(cardList);
    }

    public ICard crearUno() {
        return new CardGold(1, "rutaImg", false, false);
    }

    public ICard crearDos() {
        return new CardGold(2, "rutaImg", false, false);
    }

    public ICard crearTres() {
        return new CardGold(3, "rutaImg", false, false);
    }

    public ICard crearCuatro() {
        return new CardGold(4, "rutaImg", false, false);
    }

    public ICard crearCinco() {
        return new CardGold(5, "rutaImg", false, false);
    }

    public ICard crearSeis() {
        return new CardGold(6, "rutaImg", false, false);
    }

    public ICard crearSiete() {
        return new CardGold(7, "rutaImg", false, false);
    }

    public ICard crearDiez() {
        return new CardGold(10, "rutaImg", false, false);
    }

    public ICard crearOnce() {
        return new CardGold(11, "rutaImg", false, false);
    }

    public ICard crearDoce() {
        return new CardGold(12, "rutaImg", false, false);
    }
}
