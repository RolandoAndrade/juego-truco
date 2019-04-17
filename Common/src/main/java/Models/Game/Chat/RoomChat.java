package Models.Game.Chat;

import java.util.ArrayList;

public interface RoomChat
{
    ArrayList<RoomMessage> getMessages();
    void addMessage(RoomMessage message);
}
