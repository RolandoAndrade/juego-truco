package Models.Card;

import Services.Strategies.Cards.PlayCardStrategy;

/**
 * Clase que define el modelo de una carta, con todos sus
 * atributos y constructores necesarios para su creacion.
 *
 * @author Jose C.
 * @author Rolando A.
 * @see PlayCard
 */
public abstract class Card implements PlayCard
{
    private final int cardNumber;
    
    /**
     * Valor de la carta, este no se define como final ya que si puede cambiar
     * dependiendo de si la carta es perico o perica, este puede tomar diferentes valores.
     */
    
    private PlayCardStrategy cardStrategy;
    
    private int value;
    
    private String imagePath;
    
    private String type;
    
    
    /**
     * Solo se define el tipo de carta que sera ya que el  valor, ruta
     * de la imagen estaran dentro de la clase concreta
     **/
    public Card(int cardNumber, String imagePath)
    {
        this.cardNumber = cardNumber;
        this.imagePath = imagePath;
    }
    
    //Estos constructores seran eliminados proximamente...
    public Card(int cardNumber, String imagePath, String type)
    {
        this.cardNumber = cardNumber;
        this.imagePath = imagePath;
        this.type = type;
    }
    
    
    public Card(int cardNumber, int value, String imagePath)
    {
        this.cardNumber = cardNumber;
        this.value = value;
        this.imagePath = imagePath;
    }
}
