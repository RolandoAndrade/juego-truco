package Factory;


import Models.Card.ICard;

import java.util.ArrayList;

public abstract class CardFactory {
    public ArrayList<ICard> cardList;

    public CardFactory() {
        this.cardList = new ArrayList<>();
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

    public abstract ICard crearUno();
    public abstract ICard crearDos();
    public abstract ICard crearTres();
    public abstract ICard crearCuatro();
    public abstract ICard crearCinco();
    public abstract ICard crearSeis();
    public abstract ICard crearSiete();
    /**
     * Hay que tener en cuenta que el diez y once
     * pueden ser el perico dependiendo de la carta
     * que se voltea
     * */
    public abstract ICard crearDiez(); //sota
    public abstract ICard crearOnce(); //caballo
    public abstract ICard crearDoce(); //rey


}
