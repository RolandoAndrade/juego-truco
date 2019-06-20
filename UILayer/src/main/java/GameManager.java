import Command.Command;
import Models.Card.PlayCard;
import Models.Game.PlayGame;

public class GameManager
{
    private static int TURN_OF_PLAYER=0;
    private static int NUMBER_OF_TURNS=0;
    private static int NUMBER_OF_ROUNDS=0;
    private static PlayCard[] cards = {null,null,null,null};
    private static PlayGame gameRoom;
    private static Command fill;
    private static FrameControl frameControl;
    
    private static int globalScoreTeamA=0;
    private static int globalScoreTeamB=0;
    
    private static int TeamAScore=0;
    private static int TeamBScore=0;
    
    private static int trickRate=1;
    
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
            if(TURN_OF_PLAYER>-1)
            {
                System.out.println("Gana jugador "+gameRoom.getPlayer(TURN_OF_PLAYER).getName());
            }
            else
            {
                System.out.println("Empate");
            }
            NUMBER_OF_TURNS=0;
            endRound();
        }
    }
    
    private static void endRound()
    {
        if(NUMBER_OF_ROUNDS==2)
            try
            {
                fill.execute();
                gameRoom.cleanPlayedCards();
                frameControl.update();
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
        if(!draw)
        {
            if(winner%2==0)
                TeamAScore+=trickRate;
            else
                TeamBScore+=trickRate;
            return winner;
        }
        return resolveDraw();
    }
    
    private static int resolveDraw()
    {
        int p0=cards[0].getPoints();
        int p1=cards[1].getPoints();
        int p2=cards[2].getPoints();
        int p3=cards[3].getPoints();
        int TeamA[]={Math.max(p0,p2),Math.min(p0,p2)};
        int TeamB[]={Math.max(p1,p3),Math.min(p1,p3)};
        if(TeamA[0]>TeamB[0])
        {
            //Empate entre compañeros
            return 0;
        }
        else if(TeamB[0]>TeamA[0])
        {
            //Empate entre compañeros
            return 1;
        }
        return -1;
        
    }
    
    public static void setFill(Command fill)
    {
        GameManager.fill = fill;
    }
    
    public static void setFrameControl(FrameControl frameControl)
    {
        GameManager.frameControl = frameControl;
    }
    
    public static void setGameRoom(PlayGame gameRoom)
    {
        GameManager.gameRoom=gameRoom;
    }
}
