/**
   Mock strategy for a computer to pick the next move
   on a 3 x 3 tic-tac-toe board. This strategy
   searches for the first unoccupied square.
*/
public class MockTicTacToeStrategy implements ITicTacToeStrategy
{
   /**
      Computes the next move a computer makes.
      @param a tic tac toe board
      @return a string containing the row and column for the next move
   */
   public String getMove(TicTacToeBoard board)
   {
      String boardPositions = board.toString();
      int firstSpace = boardPositions.indexOf(" ");
      int ROW_LENGTH = 6;
         // Each row has length 6 because of the | | on the side
         // and the newline at the end
      int row = firstSpace / ROW_LENGTH + 1; 
      int column = firstSpace % ROW_LENGTH;
      return row + " " + column;
   }
}
