package Models.Card.Ten;

public abstract class TenStrategy
{
    private final int VALUE;
    
    protected TenStrategy(int VALUE)
    {
        this.VALUE = VALUE;
    }
    
    public int getValue()
    {
        return this.VALUE;
    }
}
