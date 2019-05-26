import Command.*;
import Models.Card.Card;
import Models.Card.PlayCard;
import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import Models.Player.PlayPlayer;
import Models.Player.Player;
import Services.Strategies.Cards.OneCardSword;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Board implements Paintable
{
    PlayDeck deck;
    private ArrayList<PlayPlayer> players;
    private GraphicCard vira;
    public Board()
    {
        /**Aquí estou haciendo las pruebas de interfaz*/
        deck=new Deck();
        deck.mix();
        Command fillDeskCommand=new FillDeskCommand(deck);
        
        players=new ArrayList<PlayPlayer>();
        players.add(new GraphicPlayer(0,"ROLANDO", new GraphicHand()));
        players.add(new GraphicPlayer(1,"JOSÉ", new GraphicHand()));
        players.add(new GraphicPlayer(2,"ANDRADE", new GraphicHand()));
        players.add(new GraphicPlayer(3,"FERNÁNDEZ", new GraphicHand()));
        Command distributeCardsCommand=new DistributeCardsCommand(deck,players);
        try
        {
            fillDeskCommand.execute();
            distributeCardsCommand.execute();
            vira=new GraphicCard(deck.pickCard(),320,190,true);
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
        
        
        
    }

    
    public PlayPlayer getPlayer()
    {
        return this.players.get(0);
    }
    
    @Override
    public void paint(Graphics g, ImageObserver observer)
    {
        for (PlayPlayer a:this.players)
        {
            ((Drawable)a).paint(g,observer);
        }
        vira.paint(g,observer);
    }
}
