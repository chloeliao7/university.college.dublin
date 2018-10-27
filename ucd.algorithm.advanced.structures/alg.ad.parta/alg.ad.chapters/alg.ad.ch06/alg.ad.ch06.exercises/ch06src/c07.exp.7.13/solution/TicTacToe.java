/**
   A 3 x 3 Tic-Tac-Toe board.
*/
public class TicTacToe
{
   private String[][] board;
   private static final int ROWS = 3;
   private static final int COLUMNS = 3;

   /**
      Constructs an empty board.
   */
   public TicTacToe()
   {
      board = new String[ROWS][COLUMNS];

      // fill with spaces
      for (int i = 0; i < ROWS; i++)
         for (int j = 0; j < COLUMNS; j++)
            board[i][j] = " ";
   }

   /**
      Sets a field in the board. The field must be unoccupied.
      @param i the row index 
      @param j the column index 
      @param player the player ("x" or "o")
   */
   public void set(int i, int j, String player)
   {
      if (board[i][j].equals(" "))
         board[i][j] = player;
   }

   /**
      Creates a string representation of the board such as
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
      Gets the winner
      @return the winner
   */
   public String getWinner()
   {  
      // check rows
      for (int i = 0; i < board.length; i++)
      {  
         String p = board[i][0];
         boolean same = true;
         for (int j = 1; j < board.length && same; j++)
         {
            if (!p.equals(board[i][j])) 
               same = false;
         }
         if (same) 
            return p;
      }
      // check columns
      for (int i = 0; i < board.length; i++)
      {  
         String p = board[0][i];
         boolean same = true;
         for (int j = 1; j < board.length && same; j++)
         {
            if (!p.equals(board[j][i])) 
               same = false;
         }
         if (same) 
            return p;
      }
      // check diagonals
      String p = board[0][0];
      boolean same = true;
      for (int j = 1; j < board.length && same; j++)
      {
         if (!p.equals(board[j][j])) 
            same = false;
      }
      if (same) 
         return p;
      p = board[0][board.length - 1];
      same = true;
      
      for (int j = 1; j < board.length && same; j++)
      {
         if (!p.equals(board[j][board.length - 1 - j])) 
            same = false;
      }
      if (same) 
         return p;
      return " ";
   }   
}
