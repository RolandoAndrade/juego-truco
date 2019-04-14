package Exceptions;

public class DeckEmptyException extends CustomException
{
    public DeckEmptyException()
    {
        super("Deck is empty");
    }
}
