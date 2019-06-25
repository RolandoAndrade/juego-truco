package Serial;

import Models.Card.PlayCard;
import Models.Deck.PlayDeck;
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
    
    public static void giveCards(ArrayList<PlayPlayer> players)
    {
        try
        {
            Map<String,String> selector = new HashMap<>();
            selector.put("gold", "O");
            selector.put("course", "B");
            selector.put("sword", "E");
            selector.put("cup", "C");
            String[] px={"A","B","C","D"};
            for(int i=0;i<players.size();i++)
            {
                ArrayList<PlayCard> cards= players.get(i).getHand().getCards();//Pecado
                StringBuilder msg= new StringBuilder("$$$S"+px[i]);
                for (PlayCard c: cards)
                {
                    msg.append(c.getNumber() < 10 ? "#" + c.getNumber() : "" + c.getNumber()).append(selector.get(c.getTypeOfCard()));
                }
                msg.append("%%");
                serialPort.purgePort(SerialPort.PURGE_TXCLEAR | SerialPort.PURGE_RXCLEAR);
                serialPort.writeString(msg.toString());
                
            }
        }
        catch (Exception e)
        {
            System.err.println("Error al enviar mensaje");
        }
    }
    
    public static void setCardsFromMessage(String cards)
    {
        char c=cards.charAt(0);
    }
    
    public static void sentTurno()
    {

    }
}
