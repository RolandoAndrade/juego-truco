public class TrickButton extends Button
{
    public TrickButton(int x, int y, String name)
    {
        super(x, y, name);
    }
    
    @Override
    public boolean onClick(int x, int y)
    {
        boolean a = super.onClick(x, y);
        if(a) GameManager.trick();
        return a;
    }
}
