package Models.Game.Chat;

public class Message implements RoomMessage
{
    String text;
    
    public Message(String text)
    {
        this.text = text;
    }
    
    @Override
    public String getText()
    {
        return text;
    }
}
