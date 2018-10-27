/**
   A 3 x 3 tic-tac-toe board.
*/
public class TicTacToeBoard
{
   private String[][] board;
   private static final int ROWS = 3;
   private static final int COLUMNS = 3;

   /**
      Constructs an empty board.
   */
   public TicTacToeBoard()
   {
      board = new String[ROWS][COLUMNS];
      // Fill with spaces
      for (int i = 0; i < ROWS; i++)
         for (int j = 0; j < COLUMNS; j++)
            board[i][j] = " ";
   }

   /**
      Sets a field in the board. The field must be unoccupied.
      @param move the move in the form "row col" (between 1 and 3)
      for example "1 3" for the top right corner
      @param player the player ("x" or "o")
   */
   public void makeMove(String move, String player)
   {
      int i = Integer.parseInt(move.trim().substring(0, 1)) - 1;
      int j = Integer.parseInt(move.trim().substring(1).trim()) - 1;
      if (board[i][j].equals(" "))
         board[i][j] = player;
   }

   /**
      Creates a string representation of the board, such as
      |x  o|
      |  x |
      |   o|
      @return the string representation
   */
   public String toString()
   {
      String r = "";
      for (int i = 0; i < ROWS; i++)
      {
         r = r + "|";
         for (int j = 0; j < COLUMNS; j++)         
            r = r + board[i][j];
         r = r + "|\n";
      }
      return r;
   }
   
   /**
      Checks whether the game is over
      @return true if the game is over
   */
   public boolean isOver()
   {  
      // check rows
      for (int i = 0; i < ROWS; i++)
      {           
         String p = board[i][0];
         if (!p.equals(" ") 
               && p.equals(board[i][1]) && p.equals(board[i][2])) 
            return true;
      }
      // check columns
      for (int i = 0; i < COLUMNS; i++)
      {  
         String p = board[0][i];
         if (!p.equals(" ") 
               && p.equals(board[1][i]) && p.equals(board[2][i])) 
            return true;
      }
      // check diagonals
      String p = board[1][1];
      return !p.equals(" ") 
         && (p.equals(board[0][0]) && p.equals(board[2][2])
         || p.equals(board[2][0]) && p.equals(board[0][2]));
   }   
}
