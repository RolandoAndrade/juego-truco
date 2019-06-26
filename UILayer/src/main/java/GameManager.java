import Command.Command;
import Models.Card.PlayCard;
import Models.Game.PlayGame;
import Models.Player.PlayPlayer;
import Models.Score.PlayScore;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager
{
    public static int SERVER_PLAYER=0;
    private static int PLAYER;
    private static int TURN_OF_PLAYER=0;
    private static int NUMBER_OF_TURNS=0;
    private static int NUMBER_OF_ROUNDS=0;
    private static PlayCard[] cards = {null,null,null,null};
    private static PlayGame gameRoom;
    private static Command fill;
    private static FrameControl frameControl;
    private static int TeamAScore=0;
    private static int TeamBScore=0;
    private static PlayScore score;
    
    
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
            int ww=whoWins();
            if(ww>-1)
            {
                if(ww%2==0)
                    TeamAScore++;
                else
                    TeamBScore++;
                TURN_OF_PLAYER=ww;
                JOptionPane.showMessageDialog((JFrame)frameControl,
                        "Ha ganado "+gameRoom.getPlayer(TURN_OF_PLAYER).getName());
                if(TeamAScore==2||TeamBScore==2)
                {
                    NUMBER_OF_ROUNDS=2;
                }
            }
            else
            {
                JOptionPane.showMessageDialog((JFrame)frameControl,
                        "Empate");
                TURN_OF_PLAYER=(TURN_OF_PLAYER+1)%4;
            }
            NUMBER_OF_TURNS=0;
            endRound();
        }
    }
    
    private static void endRound()
    {
        //Verifica que se jugaran las 3 rondas de cartas
        if(NUMBER_OF_ROUNDS==2)
        {
            try
            {
                fill.execute();
                gameRoom.cleanPlayedCards();
                frameControl.update();
                score.endRound(TeamAScore,TeamBScore);
                TeamAScore=0;
                TeamBScore=0;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
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
            draw=draw||a==max;
            if(a>max)
            {
                max=a;
                draw=false;
                winner=i;
            }
        }
        if(!draw)
        {
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
        int[] TeamA = {Math.max(p0, p2), Math.min(p0, p2)};
        int[] TeamB = {Math.max(p1, p3), Math.min(p1, p3)};
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
        //Empate entre rivales
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
    
    public static void trick()
    {
        String[] s = {"Sí quiero", "No quiero"};
        if (score.actualTrick() != null)
        {
            int n = JOptionPane.showOptionDialog((JFrame) frameControl, score.actualTrick(),
                    "Hay una propuesta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, s, s[1]);
            if (n == JOptionPane.YES_OPTION)
            {
                score.trick();
            } else
            {
                //giveup
            }
        }
    }
    
    public static void setScore(PlayScore score)
    {
        GameManager.score=score;
    }
    
    public static void selectPlayer()
    {
        String[] players = {"0","1","2","3"};
        PLAYER=Integer.parseInt((String)JOptionPane.showInputDialog(new JFrame("NADA"),"Introduce el jugador",
                "Configuración de puerto", JOptionPane.QUESTION_MESSAGE,null,
                players,players[0]));
    }
    
    public static int getPLAYER()
    {
        return PLAYER;
    }
    
    public static void setPlayersCards(ArrayList<PlayCard> cards, int i)
    {
        System.out.println(gameRoom.getPlayer(i).getHand());
        gameRoom.getPlayer(i).getHand().setCardList(cards);
        System.out.println(gameRoom.getPlayer(i).getHand());
        frameControl.update();
    }
}
