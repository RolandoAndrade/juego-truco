package Factory;

import Models.Card.ICard;

import java.util.ArrayList;


public class CardSwordFactory extends CardFactory {

    public CardSwordFactory(ArrayList<ICard> cardList) {
        super(cardList);
    }

    @Override
    public ICard crearUno() {
        return null;
    }

    @Override
    public ICard crearDos() {
        return null;
    }

    @Override
    public ICard crearTres() {
        return null;
    }

    @Override
    public ICard crearCuatro() {
        return null;
    }

    @Override
    public ICard crearCinco() {
        return null;
    }

    @Override
    public ICard crearSeis() {
        return null;
    }

    @Override
    public ICard crearSiete() {
        return null;
    }

    @Override
    public ICard crearDiez() {
        return null;
    }

    @Override
    public ICard crearOnce() {
        return null;
    }

    @Override
    public ICard crearDoce() {
        return null;
    }
}
