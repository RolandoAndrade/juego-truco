package Models.Game;

import Models.Player.*;
import java.util.ArrayList;



public class Round implements PlayRound {

    private GameRoom gameRoom;
    private PlayPlayer winner;
    private ArrayList<PlayPlayer> players;


    public Round (){
        this.gameRoom = new GameRoom();
        this.winner = null;
        this.players = this.gameRoom.getPlayers();
    }
    public Round (GameRoom gameRoom){
        this.gameRoom = gameRoom;
        this.winner = null;
        this.players = this.gameRoom.getPlayers();
    }


    public void playRound(){

        PlayPlayer bestTeam1Card = compareCards(this.players.get(0),this.players.get(2) );
        PlayPlayer bestTeam2Card = compareCards(this.players.get(1),this.players.get(3) );

        if ( bestTeam1Card != bestTeam2Card){
            this.winner = compareCards(bestTeam1Card, bestTeam2Card);
        }

    }
    
    public PlayPlayer compareCards(PlayPlayer player1, PlayPlayer player2){

        /** 
         * Obtener el valor de la carta del player1 y se guarda
         * en card1.
         * Obtener el valor de la carta del player2 y se guarda
         * en card2.
         */ 
        int card1 = ;
        int card2 = ;
        
        if( card1 >= card2 ){

            return player1;

        }else if (card2 > card1){

            return player2;

        }
    }

    @Override
    public PlayPlayer getWinnerRound(){

        return this.winner;
    }

    public GameRoom getGameRoom(){
        return this.gameRoom;
    }
}
