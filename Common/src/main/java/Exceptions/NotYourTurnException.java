package Exceptions;

public class NotYourTurnException extends CustomException
{
    
    public NotYourTurnException()
    {
    }
    
    public NotYourTurnException(String message)
    {
        super(message);
    }
    
    public NotYourTurnException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
