package Models.Card.Eleven;

import Models.Card.Card;

public class Eleven extends Card {
    private ElevenStrategy isPerico;
    private int value;

    public Eleven(int number, String image) {
        super(number,image);
        this.isPerico = new NotPerico(); //Al crear la carta se crea sin ser perico.
        this.value = isPerico.getValue();
    }

    /**
     * Setter que permitira definir que la carta #11 sera perico.
     */
    public void setPerico() {
        this.isPerico = new Perico();
        this.value = isPerico.getValue();
    }

    /**
     * Setter que permitira definir que la carta #11 NO sera perico.
     */
    public void notPerico() {
        this.isPerico = new NotPerico();
        this.value = isPerico.getValue();
    }

}
