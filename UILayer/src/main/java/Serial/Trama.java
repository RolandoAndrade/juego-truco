package Serial;

public class Trama
{
    private String sender="#";//1
    private String receiver="#";//1
    private String winner="##";//2
    private String turn="#";//1
    private String envidoPower="#";//1
    private String envidoAnswer="#";//1
    private String trick="#";//1
    private String trickAnswer="#";//1
    private String playedCard="###";//3
    private static final String[] OPTIONS={"A","B","C","D","S","T"};
    
    
    public Trama(int sender, int receiver,
                 String winner, int turn, String envidoPower,
                 String envidoAnswer, String trick, String trickAnswer,
                 String playedCard)
    {
        this.sender = OPTIONS[sender];
        this.receiver = OPTIONS[receiver];
        this.winner = winner;
        this.turn = OPTIONS[turn];
        this.envidoPower = envidoPower;
        this.envidoAnswer = envidoAnswer;
        this.trick = trick;
        this.trickAnswer = trickAnswer;
        this.playedCard = playedCard;
    }
    
    public Trama(int sender, int receiver, int turn)
    {
        this.sender = OPTIONS[sender];
        this.receiver = OPTIONS[receiver];
        this.turn = OPTIONS[turn];
    }
    
    
    public String getTrama()
    {
        return "$$"+sender+receiver+winner+turn+envidoPower+envidoAnswer+trick+trickAnswer+playedCard+"%%";
    }
}
