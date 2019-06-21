package Models.Trick;

public class TrickMaker
{
    private TrickRate trickRate;
    
    public TrickMaker()
    {
        reset();
    }
    
    public void reset()
    {
        this.trickRate=new NoneTrick();
    }
    
    public int getTrickRate()
    {
        return trickRate.getValue();
    }
    
    public TrickRate trick()
    {
        if(this.trickRate instanceof NoneTrick)
        {
            this.trickRate=new Trick();
        }
        else if(this.trickRate instanceof Trick)
        {
            this.trickRate=new RedoTrick();
        }
        else if(this.trickRate instanceof RedoTrick)
        {
            this.trickRate=new LetsForNine();
        }
        else if(this.trickRate instanceof LetsForGame)
        {
            this.trickRate=new LetsForGame();
        }
        return trickRate;
    }
}
