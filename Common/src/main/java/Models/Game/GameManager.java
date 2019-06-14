package Models.Game;

import Models.Card.Card;
import Models.Card.PlayCard;
import Services.Strategies.GameStates.GameState;

import java.util.ArrayList;

public class GameManager
{
    private static int TURN_OF_PLAYER=0;
    private static int NUMBER_OF_TURNS=0;
    private static PlayCard[] cards = {null,null,null,null};
    private static Card vira = null;
    
    
    public static boolean isMyTurn(int numberOfPlayer)
    {
        return TURN_OF_PLAYER==numberOfPlayer;
    }
    
    public static void finishMyTurn(PlayCard card)
    {
        cards[TURN_OF_PLAYER]=card;
        TURN_OF_PLAYER=(TURN_OF_PLAYER+1)%4;
        NUMBER_OF_TURNS++;
        if (NUMBER_OF_TURNS==4)
        {
            System.out.println("Termino");
        }
    }
    
    private static int whoWins()
    {
        boolean someoneWins=false;
        int winner=0;
        for (int i=0;i<cards.length-1;i++)
        {
            GameState s = cards[i].play(cards[i+1]);
            
        }
        return 0;
    }
}
