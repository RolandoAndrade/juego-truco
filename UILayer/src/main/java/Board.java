import Command.Command;
import Command.FillDeskCommand;
import Models.Card.Card;
import Models.Card.PlayCard;
import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import Models.Player.PlayPlayer;
import Models.Player.Player;
import Services.Strategies.Cards.OneCardSword;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    PlayDeck deck;
    private Drawable player0;
    private Drawable player1;
    private Drawable player2;
    private Drawable player3;
    public Board()
    {
        deck=new Deck();
        Command fillDeskCommand=new FillDeskCommand(deck);
        try
        {
            fillDeskCommand.execute();
            this.player0=new GraphicPlayer(0,"ROLANDO", new GraphicHand());
            this.player1=new GraphicPlayer(1,"JOSÉ", new GraphicHand());
            this.player2=new GraphicPlayer(2,"ANDRADE", new GraphicHand());
            this.player3=new GraphicPlayer(3,"FERNÁNDEZ", new GraphicHand());
            for (int i=0;i<3;i++)
            {
                PlayCard card=deck.pickCard();
                System.out.println(card);
                ((GraphicPlayer)player0).giveCard(new GraphicCard(card,60*i+10,300,true));
                /*((GraphicPlayer)player1).giveCard(new GraphicCard(deck.pickCard(),60*i+450,300,true));
                ((GraphicPlayer)player2).giveCard(new GraphicCard(deck.pickCard(),60*i+450,100,true));
                ((GraphicPlayer)player3).giveCard(new GraphicCard(deck.pickCard(),60*i+10,100,true));*/
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
        
        
        this.setBackground(new Color(33, 33, 33));
        
        /*Card card=new Card(1, "sword",new OneCardSword());
        this.card=new GraphicCard(card,250,300, true);
        card=new Card(6, "course",new OneCardSword());
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
