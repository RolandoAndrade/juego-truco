package Models.Card;

/**
 * Clase que define el modelo de una carta, con todos sus
 * atributos y constructores necesarios para su creacion.
 *
 * @author Jose C.
 * @author Rolando A.
 * @see PlayCard
 */
public abstract class Card implements PlayCard {
    /**
     * Final ya que el numero de la carta nunca puede cambiar
     */
    private final int number;

    /**
     * Valor de la carta, este no se define como final ya que si puede cambiar
     * dependiendo de si la carta es perico o perica, este puede tomar diferentes valores.
     */
    private int value;
    /**
     * Ruta donde se encuentra la imagen de la carta.
     */
    private String image;

    public Card(int number, String image) {
        this.number = number;
        this.image = image;
    }

    public Card(int number, int value, String image) {
        this.number = number;
        this.value = value;
        this.image = image;
    }
}
