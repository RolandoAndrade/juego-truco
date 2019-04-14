package Models.Card;

import Services.Strategies.Cards.PlayCardStrategy;

/**
 * Clase que define el modelo de una carta
 */
public class Card implements PlayCard
{
    private final int cardNumber;
    
    private PlayCardStrategy cardStrategy;
    
    private String imagePath;
    
    private String typeOfCard;
    
    public Card(int cardNumber, String imagePath)
    {
        this.cardNumber = cardNumber;
        this.imagePath = imagePath;
    }
    
    public Card(int cardNumber, String typeOfCard, PlayCardStrategy cardStrategy)
    {
        this.cardNumber = cardNumber;
        this.imagePath = "resources/"+typeOfCard+"/"+cardNumber+".jpeg";
        this.typeOfCard = typeOfCard;
        this.cardStrategy = cardStrategy;
    }
    
    //Estos constructores seran eliminados proximamente...
    public Card(int cardNumber, String imagePath, String typeOfCard)
    {
        this.cardNumber = cardNumber;
        this.imagePath = imagePath;
        this.typeOfCard = typeOfCard;
    }
    
    
    public Card(int cardNumber, int value, String imagePath)
    {
        this.cardNumber = cardNumber;
        this.imagePath = imagePath;
    }
    
    @Override
    public String toString()
    {
        return this.cardNumber+" of "+this.typeOfCard;
    }
}
