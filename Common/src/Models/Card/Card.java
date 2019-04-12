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

    private String type;


    /**
     * Solo se define el tipo de carta que sera ya que el  valor, ruta
     * de la imagen estaran dentro de la clase concreta
     **/
    public Card(int number, String image) {
        this.number = number;
        this.image = image;
    }

    //Estos constructores seran eliminados proximamente...
    public Card(int number, String image, String type) {
        this.number = number;
        this.image = image;
        this.type = type;
    }


    public Card(int number, int value, String image) {
        this.number = number;
        this.value = value;
        this.image = image;
    }
}
