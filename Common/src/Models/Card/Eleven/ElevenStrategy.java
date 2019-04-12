package Models.Card.Eleven;

public abstract class ElevenStrategy {
    private final int VALUE;

    protected ElevenStrategy(int VALUE) {
        this.VALUE = VALUE;
    }

    public int getValue() {
        return this.VALUE;
    }
}
