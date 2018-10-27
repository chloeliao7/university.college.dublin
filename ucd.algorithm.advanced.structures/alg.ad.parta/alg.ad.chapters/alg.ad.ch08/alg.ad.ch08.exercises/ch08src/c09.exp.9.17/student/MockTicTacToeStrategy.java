/**
   Mock strategy for a computer to pick the next move
   on a 3 x 3 tic-tac-toe board. This strategy
   searches for the first unoccupied square.
*/
public class MockTicTacToeStrategy implements ITicTacToeStrategy
{
   private static final int ROWS = 3;
   private static final int COLUMNS = 3;

   /**
      @param the 3 x 3 tic tac toe board 
      @return location - a two element array with
              row and column of the computer's move 
   */
   /**
      Computes the next move a computer makes.
      @param a tic tac toe board
      @return a string containing the row and column for the next move
   */
   public String getMove(TicTacToeBoard board);
   {
      . . .
   }
}
