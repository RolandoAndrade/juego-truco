package Exceptions;

public class InvalidPlayException extends CustomException
{
    
    public InvalidPlayException()
    {
    }
    
    public InvalidPlayException(String message)
    {
        super(message);
    }
    
    public InvalidPlayException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
