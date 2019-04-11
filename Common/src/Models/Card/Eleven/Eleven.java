package Models.Card.Eleven;

import Models.Card.Card;

public class Eleven extends Card {
    ElevenStrategy isPerico;

    public Eleven(int number, int value, String image) {
        super(number, value, image);
        isPerico = new NotPerico(); //Al crear la carta se crea sin ser perico.
    }

    /**
     * Setter que permitira definir que la carta #11 sera perico.
     */
    public void setPerico() {
        isPerico = new Perico();
    }

    public void notPerico(){
        isPerico = new NotPerico();
    }

}
