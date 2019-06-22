package Serial;

import jssc.SerialPort;
import jssc.SerialPortList;

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
    public static void start(String s)
    {
        String[] portNames = SerialPortList.getPortNames();
        for (String portName : portNames) System.out.println(portName);
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
        }
    }
    
    
    public static void sentTurno()
    {

    }
}
