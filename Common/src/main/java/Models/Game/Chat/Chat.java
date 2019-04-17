package Models.Game.Chat;

import java.util.ArrayList;

public class Chat implements RoomChat
{
    ArrayList<RoomMessage> messages;
    
    public Chat()
    {
        this.messages = new ArrayList<>();
    }
    
    @Override
    public ArrayList<RoomMessage> getMessages()
    {
        return messages;
    }
    
    @Override
    public void addMessage(RoomMessage message)
    {
        this.messages.add(message);
    }
}
