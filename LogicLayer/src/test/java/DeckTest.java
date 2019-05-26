import Command.Command;
import Command.FactoryCommand;
import Exceptions.DeckEmptyException;
import Models.Card.PlayCard;
import Models.Deck.Deck;
import Models.Deck.PlayDeck;
import Models.Game.GameRoom;
import Models.Game.PlayGame;
import Models.Player.Hand.Hand;
import Models.Player.PlayPlayer;
import Models.Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest
{
    private PlayDeck deck;
    private Command fillDeskCommand;
    private Command distributeCardsCommand;
    private PlayPlayer p1;
    private PlayPlayer p2;
    private PlayPlayer p3;
    private PlayPlayer p4;
    private ArrayList<PlayPlayer> playerList;
    
    @BeforeEach
    void init()
    {
        this.deck = new Deck();
        this.playerList = new ArrayList<PlayPlayer>();
        initPlayers();
        fillPlayerList();
        this.fillDeskCommand = FactoryCommand.createFillDeskCommand(deck);
        PlayGame game=new GameRoom(playerList);
        this.distributeCardsCommand = FactoryCommand.createDistributeCardsCommand(game);
    }
    
    void initPlayers(){
        this.p1 = new Player("Jose",new Hand());
        this.p2 = new Player("Pedro",new Hand());
        this.p3 = new Player("Ramiro",new Hand());
        this.p4 = new Player("Omar",new Hand());
    }
    
    void fillPlayerList(){
        this.playerList.add(p1);
        this.playerList.add(p2);
        this.playerList.add(p3);
        this.playerList.add(p4);
    }
    
    @Test
    void distributeDeckCardsTest(){
        try
        {
            fillDeskCommand.execute();
            mixCardsTest();
            distributeCardsCommand.execute(); //Comando que distribuye el deck entre los jugadores.
            assertEquals(24,deck.getCards().size());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    void fillDeckTest()
    {
        try
        {
            fillDeskCommand.execute();
            assertNotNull(deck.getCards());
            assertEquals(40, deck.getCards().size());
        } catch (Exception e)
        {
            //este catch DEBE ser cambiado
            e.printStackTrace();
        }
        
    }
    
    @Test
    void mixCardsTest()
    {
        try
        {
            fillDeskCommand.execute();
            List<PlayCard> order = (List<PlayCard>) this.deck.getCards().clone();
            this.deck.mix();
            assertNotEquals(order.toString(), this.deck.getCards().toString());
        } catch (Exception e)
        {
            mixCardsTest();
        }
    }
    
    @Test
    void pickCardTest()
    {
        try
        {
            mixCardsTest();
            PlayCard card = this.deck.pickCard();
            assertEquals(39, deck.getCards().size());
            assertNotNull(card);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    void pickTooManyCardsTest()
    {
        try
        {
            mixCardsTest();
            for (int i = 0; i < 41; i++)
            {
                PlayCard card = this.deck.pickCard();
            }
            assertTrue(false);
        } catch (DeckEmptyException e)
        {
            assertTrue(true);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    void resetDeckWhenIsEmptyTest()
    {
        try
        {
            mixCardsTest();
            for (int i = 0; i < 41; i++)
            {
                PlayCard card = this.deck.pickCard();
            }
            assertTrue(false);
        } catch (DeckEmptyException e)
        {
            fillDeckTest();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}