package Logic.Factory;

import Models.Card.CardBastos;
import Models.Card.ICard;


public class CardBastosFactory extends CardFactory {

    public CardBastosFactory() {
        super();
    }

    @Override
    public void crearTodos() {
        super.crearTodos();
    }

    @Override
    public ICard crearUno() {
        return new CardBastos(1, "rutaImg", false, false);
    }

    @Override
    public ICard crearDos() {
        return new CardBastos(2, "rutaImg", false, false);
    }

    @Override
    public ICard crearTres() {
        return new CardBastos(3, "rutaImg", false, false);
    }

    @Override
    public ICard crearCuatro() {
        return new CardBastos(4, "rutaImg", false, false);
    }

    @Override
    public ICard crearCinco() {
        return new CardBastos(5,"rutaImg",false,false);
    }

    @Override
    public ICard crearSeis() {
        return new CardBastos(6,"rutaImg",false,false);
    }

    @Override
    public ICard crearSiete() {
        return new CardBastos(7,"rutaImg",false,false);
    }

    @Override
    public ICard crearDiez() {
        return new CardBastos(10,"rutaImg",false,false);
    }

    @Override
    public ICard crearOnce() {
        return new CardBastos(11,"rutaImg",false,false);
    }

    @Override
    public ICard crearDoce() {
        return new CardBastos(12,"rutaImg",false,false);
    }
}
