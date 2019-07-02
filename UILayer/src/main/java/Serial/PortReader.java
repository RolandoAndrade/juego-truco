package Serial;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

public class PortReader implements SerialPortEventListener
{
    private SerialPort serialPort;
    private static String message="";
    
    public PortReader(SerialPort serialPort)
    {
        this.serialPort=serialPort;
    }
    
    private void receiveData(String data)
    {
        int end = data.indexOf("%%");
        
        if(end!=-1)
        {
            message+=data.substring(0, end+2);
            filter(message);
            message="";
            receiveData(data.substring(end+2));
        }
        else
        {
            message+=data;
        }
    }
    
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent)
    {
        if(serialPortEvent.isRXCHAR()&&serialPortEvent.getEventValue()>0)
        {
            try
            {
                String data = this.serialPort.readString(serialPortEvent.getEventValue());
                receiveData(data);
                
            }
            catch (Exception e)
            {
                System.out.println("Error recibiendo información");
                System.err.println(e.getMessage());
            }
        }
    }
    
    public void filter(String s)
    {
        if(s.substring(0,12).equals("$$pedirtruco"))//12 pedir truco
        {
            SerialManager.trick(s.substring(12,14));
        }
        else if(s.substring(0,11).equals("$$resptruco"))//11 responder truco
        {
            SerialManager.trickResponse(s.substring(11,14));
        }
        else if(s.substring(0,9).equals("$$jugar##"))//9 poner carta en juego
        {
            SerialManager.playCard(s.substring(9,14));
        }
        else if(s.substring(0,9).equals("$$setvira"))//9 poner vira
        {
            SerialManager.setVira(s.substring(9,14));
        }
        else if(s.substring(0,3).equals("$$r"))//Repartir cartas a jugadores
        {
            SerialManager.giveCards(s.substring(3,14));
        }
    }
}
