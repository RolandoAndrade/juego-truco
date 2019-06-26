import Factory.CardFactory;
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
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
            serialPort.addEventListener(new PortReader(serialPort));
            serialPort.writeString("Hola mundo");
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
    
    public static void giveCards(ArrayList<PlayPlayer> players)
    {

        Map<String,String> selector = parser();
        String[] px={"A","B","C","D"};
        for(int i=0;i<players.size();i++)
        {
            ArrayList<PlayCard> cards = players.get(i).getHand().getCards();//Pecado
            StringBuilder msg = new StringBuilder("$$$S" + px[i]);
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
    
    public static void setCardsFromMessage(String cards)
    {
        char c=cards.charAt(0);
        int d=translateLetters(c);
        GameManager.setPlayersCards(new CardFactory().createFromTrama(cards.substring(1)),d);
    }
    
    public static void playCard(PlayCard card, int player)
    {
        String number=card.getNumber()<10?"0"+card.getNumber():""+card.getNumber();
        String type=card.getTypeOfCard();
        String message="$$$$$$$$$"+translateNumbers(player)+"T"+number+type+"%%";
        sentMessage(message);
    }
    
    private static void sentMessage(String message)
    {
        try
        {
            serialPort.purgePort(SerialPort.PURGE_TXCLEAR | SerialPort.PURGE_RXCLEAR);
            serialPort.writeString(message);
        }
        catch (Exception e)
        {
            System.err.println("Error al enviar mensaje: "+e.getMessage());
        }
    }
    
    public static void sentTurno()
    {

    }
}
