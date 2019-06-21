package Serial;

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
                System.out.println("Recibido: "+data);
            }
            catch (Exception e)
            {
                System.out.println("Error recibiendo información");
            }
        }
    }
}
