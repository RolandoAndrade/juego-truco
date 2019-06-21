import Models.Game.GameRoom;
import Models.Player.PlayPlayer;
import Serial.PortReader;
import jssc.SerialPort;
import jssc.SerialPortList;

import java.util.ArrayList;
import java.util.Collections;

public class UITest
{
    public static void main(String []args)
    {
        String[] portNames = SerialPortList.getPortNames();
        for (String portName : portNames) System.out.println(portName);
        /**Cree en VSPE un par con puertos COM4 y COM5*/
        SerialPort serialPort=new SerialPort("COM5");
        try
        {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
            serialPort.addEventListener(new PortReader(serialPort));
            serialPort.writeString("ESTO ES UN MENSAJE");
        }
        catch (Exception e)
        {
            System.err.println("Error al abrir puerto");
        }
        ArrayList<PlayPlayer> players=new ArrayList<PlayPlayer>();
        Collections.addAll(players,
                new GraphicPlayer(0,"ROLANDO", new GraphicHand()),
                new GraphicPlayer(1,"JOSÉ", new GraphicHand()),
                new GraphicPlayer(2,"ÓSCAR", new GraphicHand()),
                new GraphicPlayer(3,"INVITADO", new GraphicHand()));
        FrameControl f=new Frame(new GameGraphicManager(new GraphicGameRoom(players)));
    }
}
