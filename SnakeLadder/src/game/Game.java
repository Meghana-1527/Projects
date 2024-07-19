package game;

import board.Board;
import player.Player;
import coordinates.Coordinates;
import dice.Dice;
import jumper.Jumper;

public class Game {
    Board board;
    Player[] players;
    boolean[] isAllowed;
    int turn;
    Coordinates[] places;
    Dice dice;

   public Game(Board board,Player[] players,Dice dice){
        this.board=board;
        this.players=players;
        this.dice=dice;
        turn=0;
        isAllowed=new boolean[players.length];
        places=new Coordinates[players.length];

        for(int i=0;i<players.length;i++) places[i]=new Coordinates(board.getBoardSize()-1, 0);
   }

   public void play(){
      while(true){
         int num=dice.diceRoll();
         System.out.println(players[turn].getPLayerName()+"rolled -> "+num+"[" + places[turn].getRow()+ "," + places[turn].getColumn()+ "]");
         if(isAllowed[turn]){
            if(num !=1){
               turn=1-turn;
               continue;
            } 
            else{
              isAllowed[turn]=true;  
            }
         }

         Coordinates newCoordinates=getnewCoordinates(places[turn],num);
         if(newCoordinates.getRow()<0){
            System.out.println(players[turn].getPLayerName()+ " has won the game" );
            return;
         }
         places[turn] = newCoordinates;
         turn=1-turn;

      } 
   }

   private Coordinates getnewCoordinates(Coordinates oldCoordinates,int num){
      int row=oldCoordinates.getRow();
      int column=oldCoordinates.getColumn();

      while(num>0){
         if(row%2==0){
            if(column==board.getBoardSize()-1) row--;
            else column++;
         }else{
            if(column==0) row--;
            else column--;
         }

         num--;
      }

      if(row<0) return new Coordinates(row, column);
      if(checkifJumperExists(row,column)){
         Jumper jumper=board.jumpers.get(board.board[row][column]);

         return jumper.end;
      }

      return new Coordinates(row,column);
   }

   private boolean checkifJumperExists(int row,int column){
      return board.jumpers.containsKey(board.board[row][column]);
   }

}

