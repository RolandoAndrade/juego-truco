import Models.Card.Card;
import Services.Strategies.Cards.OneCardSword;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private GraphicCard card;
    public Board()
    {
        this.setBackground(new Color(33, 33, 33));
        Card card=new Card(1, "sword",new OneCardSword());
        this.card=new GraphicCard(card,true);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        this.card.paint(g,this);
    }
}
