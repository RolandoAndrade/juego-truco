package Models.Card;

public abstract class Card implements ICard {
    private int number;
    private String image;
    private boolean isPerico;
    private boolean isPerica;

    public Card(int number, String image, boolean isPerico, boolean isPerica) {
        this.number = number;
        this.image = image;
        this.isPerico = isPerico;
        this.isPerica = isPerica;
    }
}
