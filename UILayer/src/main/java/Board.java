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
    private GraphicPlayer player0;
    private GraphicPlayer player1;
    private GraphicPlayer player2;
    private GraphicPlayer player3;
    private GraphicCard vira;
    private GraphicCard gDeck;
    public Board()
    {
        /**Aquí estou haciendo las pruebas de interfaz*/
        deck=new Deck();
        Command fillDeskCommand=new FillDeskCommand(deck);
        try
        {
            fillDeskCommand.execute();
            deck.mix();
            this.player0=new GraphicPlayer(0,"ROLANDO", new GraphicHand());
            this.player1=new GraphicPlayer(1,"JOSÉ", new GraphicHand());
            this.player2=new GraphicPlayer(2,"ANDRADE", new GraphicHand());
            this.player3=new GraphicPlayer(3,"FERNÁNDEZ", new GraphicHand());
            for (int i=0;i<3;i++)
            {
                player0.giveCard(new GraphicCard(deck.pickCard(),65*i+20,320,true));
                player1.giveCard(new GraphicCard(deck.pickCard(),65*i+485,320,false));
                player2.giveCard(new GraphicCard(deck.pickCard(),65*i+485,50,false));
                player3.giveCard(new GraphicCard(deck.pickCard(),65*i+20,50,false));
            }
            vira=new GraphicCard(deck.pickCard(),320,190,true);
            //gDeck=new GraphicCard(new Card(1,"gold"),320,240,false);
            
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
        vira.paint(g,this);
        //gDeck.paint(g,this);
    }
}
