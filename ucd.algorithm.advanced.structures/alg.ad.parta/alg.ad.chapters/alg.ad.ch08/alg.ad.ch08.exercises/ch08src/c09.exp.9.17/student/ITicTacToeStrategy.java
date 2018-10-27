/**
   Describes any class that computes the next move for a
   tic tac toe game, using any strategy.
*/
public interface ITicTacToeStrategy
{
   /**
      Computes the next move a computer makes.
      @param a tic tac toe board
      @return a string containing the row and column for the next move
   */
   String getMove(TicTacToeBoard board);
}
