package GameManager;

import Command.Command;
import Models.Card.PlayCard;
import Models.Game.PlayGame;
import Models.Player.Hand.PlayHand;
import Models.Score.PlayScore;
import Serial.SerialManager;
import UIElements.FrameControl;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager
{
    public static final boolean TESTING = false;
    public static int SERVER_PLAYER=0;
    
    private static int trickPower = -1;
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
        System.out.println(NUMBER_OF_TURNS);
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
                if(PLAYER==SERVER_PLAYER)
                {
                    SerialManager.giveCards(gameRoom.getPlayers());
                    SerialManager.setVira(gameRoom.getVira());
                }
                frameControl.update();
                score.endRound(TeamAScore,TeamBScore);
                TeamAScore=0;
                TeamBScore=0;
                trickPower=-1;
                NUMBER_OF_TURNS=0;
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
        if(trickPower==-1||trickPower!=TURN_OF_PLAYER%2)
        {
            trickPower=TURN_OF_PLAYER%2;
            String[] s = {"Sí quiero", "No quiero"};
            if (score.actualTrick() != null)
            {
                SerialManager.trick(PLAYER);
                JOptionPane.showMessageDialog((JFrame) frameControl,"Acabas de enviar una oferta de truco");
            }
        }
        else
        {
            JOptionPane.showMessageDialog((JFrame) frameControl,"No tienes la voz");
        }
        
    }
    
    private static void trickRejected(int player)
    {
        NUMBER_OF_ROUNDS=2;
        if(player%2==0)
        {
            TeamAScore=60;
        }
        else
        {
            TeamBScore=60;
        }
        endRound();
    }

    public static void trick(int sender, int receiver)
    {
        if(PLAYER%2==sender%2)
        {
            JOptionPane.showMessageDialog((JFrame) frameControl,"Tu compañero acaba de pedir truco");
        }
        else if(PLAYER==receiver)
        {
            String[] s = {"Sí quiero", "No quiero"};
            int n = JOptionPane.showOptionDialog((JFrame) frameControl, score.actualTrick(),
                    "Hay una propuesta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, s, s[1]);
            if (n == JOptionPane.YES_OPTION)
            {
                score.trick();
                SerialManager.trickResponse(PLAYER,true);
            }
            else
            {
                SerialManager.trickResponse(PLAYER,false);
                trickRejected(sender);
            }
        }
        else
        {
            JOptionPane.showMessageDialog((JFrame) frameControl,"Tu compañero acaba de recibir una oferta de truco");
        }
    }
    
    public static void trickResponse(int sender, boolean accept)
    {
        if(PLAYER%2!=sender)
        {
            if(accept)
            {
                JOptionPane.showMessageDialog((JFrame) frameControl,"Truco aceptado");
                score.trick();
            }
            else
            {
                JOptionPane.showMessageDialog((JFrame) frameControl,"Truco rechazado");
                trickRejected(PLAYER);
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
        gameRoom.getPlayer(i).getHand().setCardList(cards);
        frameControl.update();
    }
    
    public static void playCard(int player, PlayCard card)
    {
        PlayHand h=gameRoom.getPlayer(player).getHand();
        int i=0;
        for(PlayCard c: h.getCards())
        {
            System.out.println(c.getNumber()+" "+card.getNumber()+" "+c.getColor()+" "+card.getColor()+" "+i);
            if(c.getNumber()==card.getNumber()&&c.getColor().equals(card.getColor()))
            {
                gameRoom.getPlayer(player).getHand().putCard(i);
                finishMyTurn(gameRoom.getPlayer(player).getHand().getPlayedCard());
                frameControl.update();
                return;
            }
            i++;
        }
        
    }
    
    public static void setVira(PlayCard card)
    {
        gameRoom.setVira(card);
        frameControl.update();
    }
}
