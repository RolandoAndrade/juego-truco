import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

public class PortReader implements SerialPortEventListener
{
    private SerialPort serialPort;
    
    
    public PortReader(SerialPort serialPort)
    {
        this.serialPort=serialPort;
    }
    
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent)
    {
        if(serialPortEvent.isRXCHAR()&&serialPortEvent.getEventValue()>0)
        {
            try
            {
                String data = this.serialPort.readString(serialPortEvent.getEventValue());
                for(int i=0;i<data.length()/16;i++)
                {
                    String substring = data.substring(i * 16, i * 16 + 16);
                    System.out.println("Recibido: "+ substring);
                    filter(substring);
                }
                //System.out.println("Recibido: "+data);
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
        
        if(s.substring(0,9).equals("$$$$$$$$$"))
        {
            SerialManager.playCard(s.substring(9,14));
        }
        else if(s.substring(0,3).equals("$$$"))
        {
            SerialManager.giveCards(s.substring(4,14));
        }
    }
}
