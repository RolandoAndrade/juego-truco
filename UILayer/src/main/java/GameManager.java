import Command.Command;
import Models.Card.Card;
import Models.Card.PlayCard;

public class GameManager
{
    private static int TURN_OF_PLAYER=0;
    private static int NUMBER_OF_TURNS=0;
    private static int NUMBER_OF_ROUNDS=0;
    private static PlayCard[] cards = {null,null,null,null};
    private static Card vira = null;
    private static Command fill=null;
    
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
            TURN_OF_PLAYER=whoWins();
            NUMBER_OF_TURNS=0;
            System.out.println("Gana Jugador "+TURN_OF_PLAYER);
            endRound();
        }
    }
    
    private static void endRound()
    {
        if(NUMBER_OF_ROUNDS==2)
            try
            {
                fill.execute();
                System.out.println("Ebr");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        NUMBER_OF_ROUNDS=(NUMBER_OF_ROUNDS+1)%3;
    }
    
    private static int whoWins()
    {
        int max=-1;
        boolean draw=false;
        int winner=0;
        for(int i=0;i<cards.length;i++)
        {
            int a = cards[i].getPoints();
            draw=a==max;
            if(a>max)
            {
                max=a;
                draw=false;
                winner=i;
            }
        }
        return !draw?winner:0;
    }
    
    public static void setFill(Command fill)
    {
        GameManager.fill = fill;
    }
}
