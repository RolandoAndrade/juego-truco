package Serial;

import Factory.CardFactory;
import GameManager.GameManager;
import Models.Card.Card;
import Models.Card.PlayCard;
import Models.Player.PlayPlayer;
import jssc.SerialPort;
import jssc.SerialPortList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SerialManager
{
    
    private static final int NUMBER_OF_PLAYERS=4;
    
    /**
     * Inicio de la trama   ($$)
     * Emisor               (A,B,C,D,S,T)
     * Destinatario         (A,B,C,D,S,T)
     * GANADOR JUEGO        (AC, BD, SG)
     * TURNO                (A,B,C,D)
     * PODER DE ENVIDO      (S,#)
     * RESPUESTA ENVIDO     (S,N,#)
     * PEDIR TRUCO          (S,#)
     * RESPUESTA TRUCO      (S,N,#)
     * CARTA JUGADA         (#1-12 B, C, E, O)
     * FINAL DE TRAMA       (%%)
     * */
    private static SerialPort serialPort;
    public static void start()
    {
        String[] portNames = SerialPortList.getPortNames();
        String s=(String) JOptionPane.showInputDialog(new JFrame("NADA"),"Introduce el puerto",
                "Configuración de puerto", JOptionPane.QUESTION_MESSAGE,null,
                portNames,portNames[0]);
        /**Cree en VSPE un par con puertos COM4 y COM5*/
        serialPort=new SerialPort(s);
        try
        {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_1200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            serialPort.addEventListener(new PortReader(serialPort));
        }
        catch (Exception e)
        {
            System.err.println("Error al abrir puerto");
            JOptionPane.showMessageDialog(new JFrame("NADA"),
                    "Error al abrir puerto, el puerto que ha seleccionado no se encuantra disponible",
                    "Error al abrir puerto",JOptionPane.ERROR_MESSAGE);
            start();
        }
    }
    
    private static HashMap<String,String> parser()
    {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("gold", "O");
        selector.put("course", "B");
        selector.put("sword", "E");
        selector.put("cup", "C");
        return selector;
    }
    
    private static HashMap<String,String> deParser()
    {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("O","gold");
        selector.put("B","course");
        selector.put("E","sword");
        selector.put("C","cup");
        return selector;
    }
    
    public static void giveCards(ArrayList<PlayPlayer> players)
    {

        Map<String,String> selector = parser();
        String[] px={"A","B","C","D"};
        for(int i=0;i<players.size();i++)
        {
            ArrayList<PlayCard> cards = players.get(i).getHand().getCards();//Pecado
            StringBuilder msg = new StringBuilder("$$rS" + px[i]);
            for (PlayCard c : cards)
            {
                msg.append(c.getNumber() < 10 ? "0" + c.getNumber() : "" + c.getNumber()).append(selector.get(c.getTypeOfCard()));
            }
            msg.append("%%");
            sentMessage(msg.toString());
        }
    }
    
    private static String translateNumbers(int n)
    {
        String[]s={"A","B","C","D"};
        return s[n];
    }
    
    private static int translateLetters(char c)
    {
        switch (c)
        {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
        }
        return 0;
    }
    
    public static boolean giveCards(String cards)
    {
        int sender = translateLetters(cards.charAt(0));
        if(sender != GameManager.getPLAYER())
        {
            int receiver = translateLetters(cards.charAt(1));
            GameManager.setPlayersCards(new CardFactory().createFromTrama(cards.substring(2)),receiver);
            return true;
        }
        return false;
    }
    
    public static void playCard(PlayCard card, int player)
    {
        String number=card.getNumber()<10?"0"+card.getNumber():""+card.getNumber();
        String type=parser().get(card.getTypeOfCard());
        String message="$$jugar##"+translateNumbers(player)+"T"+number+type+"%%";
        sentMessage(message);
    }
    
    public static boolean playCard(String card)
    {
        int sender = translateLetters(card.charAt(0));
        if(sender!=GameManager.getPLAYER())
        {
            int number = Integer.parseInt(card.substring(2, 4));
            PlayCard car = new Card(number, deParser().get(card.substring(4)));
            GameManager.playCard(sender, car);
            return true;
        }
        return false;
    }
    
    public static void sentMessage(String message)
    {
        try
        {
            //serialPort.purgePort(SerialPort.PURGE_TXCLEAR | SerialPort.PURGE_RXCLEAR);
            serialPort.writeString(message);
        }
        catch (Exception e)
        {
            System.err.println("Error al enviar mensaje: "+e.getMessage());
        }
    }
    
    public static void setVira(PlayCard card)
    {
        String number = card.getNumber() < 10 ? "0" + card.getNumber() : "" + card.getNumber();
        String type = parser().get(card.getTypeOfCard());
        String message = "$$setvira" + "ST" + number + type + "%%";
        sentMessage(message);
    }
    
    public static boolean setVira(String message)
    {
        int sender = translateLetters(message.charAt(0));
        if(sender != GameManager.getPLAYER())
        {
            int number = Integer.parseInt(message.substring(2, 4));
            String type = deParser().get(message.substring(4));
            PlayCard card = new Card(number, type);
            GameManager.setVira(card);
            return true;
        }
        return false;
    }
    
    public static void trick(int player)
    {
        String message="$$pedirtruco"+translateNumbers(player)+translateNumbers((player+1)%NUMBER_OF_PLAYERS)+"%%";
        sentMessage(message);
    }
    
    public static boolean trick(String s)
    {
        int sender=translateLetters(s.charAt(0));
        if(sender!=GameManager.getPLAYER())
        {
            int receiver=translateLetters(s.charAt(1));
            GameManager.trick(sender, receiver);
            return true;
        }
        return false;
    }
    
    public static void trickResponse(int player, boolean ans)
    {
        String message="$$resptruco"+translateNumbers(player)+"T"+(ans?"S":"N")+"%%";
        sentMessage(message);
    }
    
    public static boolean trickResponse(String s)
    {
        int sender=translateLetters(s.charAt(0));
        if(sender!=GameManager.getPLAYER())
        {
            boolean accept = s.charAt(2) == 'S';
            GameManager.trickResponse(sender, accept);
            return true;
        }
        return false;
    }
    
    public static void handShake()
    {
        String message = "$$hand#shake"+translateNumbers(GameManager.getPLAYER())+"S"+"%%";
        sentMessage(message);
    }
    
    public static void handShake(String s)
    {
        int sender = translateLetters(s.charAt(0));
        System.out.println("Solicitud de handshake "+ sender+ " "+GameManager.SERVER_PLAYER);
        if(sender == GameManager.SERVER_PLAYER&&GameManager.getPLAYER() == GameManager.SERVER_PLAYER)
        {
            GameManager.setUp();
        }
        else if(GameManager.getPLAYER() == GameManager.SERVER_PLAYER)
        {
            System.out.println("Soy el servidor, espero respuesta");
            handShake();
        }
        else
        {
            System.out.println("No soy servidor, intento retransmitir");
            sentMessage("$$hand#shake"+s+"%%");
        }
        
    }
}
