package Models.Card.Ten;

import Models.Card.Card;

public class Ten extends Card
{
    private TenStrategy isPerica;
    private int value;
    
    public Ten(int number, String image)
    {
        super(number, image);
        this.isPerica = new NotPerica(); //Al crear la carta se crea sin ser perico.
        this.value = isPerica.getValue();
    }
    
    /**
     * Setter que permitira definir que la carta #11 sera perica.
     */
    public void setPerica()
    {
        this.isPerica = new Perica();
        this.value = isPerica.getValue();
    }
    
    /**
     * Setter que permitira definir que la carta #10 NO sera perica.
     */
    public void notPerico()
    {
        this.isPerica = new NotPerica();
        this.value = isPerica.getValue();
    }
    
}
