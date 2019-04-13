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
public class Card implements PlayCard
{
    private final int cardNumber;
    
    /**
     * Valor de la carta, este no se define como final ya que si puede cambiar
     * dependiendo de si la carta es perico o perica, este puede tomar diferentes valores.
     */
    
    private PlayCardStrategy cardStrategy;
    
    private String imagePath;
    
    private String type;
    
    public Card(int cardNumber, String imagePath)
    {
        this.cardNumber = cardNumber;
        this.imagePath = imagePath;
    }
    
    public Card(int cardNumber, String type, PlayCardStrategy cardStrategy)
    {
        this.cardNumber = cardNumber;
        this.imagePath = type;
        this.type=type;
        this.cardStrategy = cardStrategy;
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
        this.imagePath = imagePath;
    }
    
    @Override
    public String toString()
    {
        return this.cardNumber+" of "+this.type;
    }
}
