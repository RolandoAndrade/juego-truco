import Models.Card.Card;
import Services.Strategies.Cards.OneCardSword;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private GraphicCard card;
    private GraphicCard card1;
    private GraphicCard card2;
    public Board()
    {
        this.setBackground(new Color(33, 33, 33));
        Card card=new Card(1, "sword",new OneCardSword());
        this.card=new GraphicCard(card,250,300, true);
        card=new Card(6, "coarse",new OneCardSword());
        this.card1=new GraphicCard(card,320,300, true);
        card=new Card(3, "gold",new OneCardSword());
        this.card2=new GraphicCard(card,390,300, true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        this.card.paint(g,this);
        this.card1.paint(g,this);
        this.card2.paint(g,this);
    }
}
