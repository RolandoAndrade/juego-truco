package Factory;

import Models.Card.ICard;

public interface ICardFactory {
    void crearTodos();
    ICard crearUno();
    ICard crearDos();
    ICard crearTres();
    ICard crearCuatro();
    ICard crearCinco();
    ICard crearSeis();
    ICard crearSiete();
    /**
     * Hay que tener en cuenta que el diez y once
     * pueden ser el perico dependiendo de la carta
     * que se voltea
     * */
    ICard crearDiez(); //sota
    ICard crearOnce(); //caballo
    ICard crearDoce(); //rey
}
