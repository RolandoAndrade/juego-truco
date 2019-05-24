import Models.Card.Card;
import Models.Player.PlayPlayer;
import Models.Player.Player;
import Services.Strategies.Cards.OneCardSword;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private Drawable player0;
    private Drawable player1;
    private Drawable player2;
    private Drawable player3;
    public Board()
    {
        this.setBackground(new Color(33, 33, 33));
        this.player0=new GraphicPlayer(0,new Player("ROLANDO", new GraphicHand()));
        this.player1=new GraphicPlayer(1,new Player("JOSÉ", new GraphicHand()));
        this.player2=new GraphicPlayer(2,new Player("ANDRADE", new GraphicHand()));
        this.player3=new GraphicPlayer(3,new Player("FERNÁNDEZ", new GraphicHand()));
        /*Card card=new Card(1, "sword",new OneCardSword());
        this.card=new GraphicCard(card,250,300, true);
        card=new Card(6, "coarse",new OneCardSword());
        this.card1=new GraphicCard(card,320,300, false);
        card=new Card(3, "gold",new OneCardSword());
        this.card2=new GraphicCard(card,390,300, true);*/
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        player0.paint(g, this);
        player1.paint(g, this);
        player2.paint(g, this);
        player3.paint(g, this);
    }
}
