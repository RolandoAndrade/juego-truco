package Models.Score;

import Models.Trick.TrickMaker;

public class Score implements PlayScore
{
    private TrickMaker trickMaker;
    private int TeamAScore;
    private int TeamBScore;
    
    public Score()
    {
        this.trickMaker=new TrickMaker();
        this.TeamAScore=0;
        this.TeamBScore=0;
    }
    
    @Override
    public boolean teamAWins()
    {
        TeamAScore+=this.trickMaker.getTrickRate();
        this.trickMaker.reset();
        return TeamAScore>23;
    }
    
    @Override
    public boolean teamBWins()
    {
        TeamBScore+=this.trickMaker.getTrickRate();
        this.trickMaker.reset();
        return TeamBScore>23;
    }
    
    @Override
    public void trick()
    {
        trickMaker.trick();
    }
    
    @Override
    public void currentScore()
    {
        System.out.println("EQUIPO A "+TeamAScore+" - "+TeamBScore+" EQUIPO B");
    }
}
