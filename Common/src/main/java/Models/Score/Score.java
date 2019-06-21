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
    
    private boolean teamAWins()
    {
        TeamAScore+=this.trickMaker.getTrickRate();
        this.trickMaker.reset();
        return TeamAScore>23;
    }
    
    private boolean teamBWins()
    {
        TeamBScore+=this.trickMaker.getTrickRate();
        this.trickMaker.reset();
        return TeamBScore>23;
    }
    
    @Override
    public int endRound(int a, int b)
    {
        if(a>b)
        {
            System.out.println("Gana ronda equipo A");
            if(teamAWins())
            {
                System.out.println("Gana partida equipo A");
                return 1;
            }
        }
        else if(a<b)
        {
            System.out.println("Gana ronda equipo B");
            if(teamBWins())
            {
                System.out.println("Gana partida equipo B");
                return 2;
            }
        }
        currentScore();
        return 0;
    }
    
    @Override
    public void trick()
    {
        trickMaker.trick();
        System.out.println("Truco. Ronda vale: "+trickMaker.getTrickRate());
    }
    
    @Override
    public void currentScore()
    {
        System.out.println("<------MARCADOR ACTUAL------>");
        System.out.println("EQUIPO A "+TeamAScore+" - "+TeamBScore+" EQUIPO B");
    }
    
    @Override
    public String actualTrick()
    {
        return trickMaker.actualTrick();
    }
    
    public int getTeamAScore()
    {
        return TeamAScore;
    }
    
    public int getTeamBScore()
    {
        return TeamBScore;
    }
}
