import java.util.Scanner;

/**
   This program runs a TicTacToe game. It prompts the
   user to set positions on the board. The computer 
   then takes a turn and prints out the results.
*/
public class TicTacToeUI
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      TicTacToeBoard game = new TicTacToeBoard();
      ITicTacToeStrategy strategy = new MockTicTacToeStrategy();
      boolean done = false;
      while (true)
      {
         // User's turn
         System.out.println(
               "Enter your move, a row (1-3) and column (1-3): " );
         String move = in.nextLine();
         game.makeMove(move, "x");
         System.out.println(game.toString());
         if (game.isOver()) return;
         
         // Computer's turn 
         move = strategy.getMove(game);   
         System.out.println("Computer's move: " + move);
         game.makeMove(move, "o");
         System.out.println(game.toString());                     
         if (game.isOver()) return;
      }
   }
}
