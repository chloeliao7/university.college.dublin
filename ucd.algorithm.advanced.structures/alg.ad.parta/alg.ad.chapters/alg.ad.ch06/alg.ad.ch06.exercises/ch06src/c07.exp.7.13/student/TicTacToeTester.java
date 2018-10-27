import java.util.Scanner;

/**
   This program tests the getWinner method of the TicTacToe class.
*/
public class TicTacToeTester
{
   public static void main(String[] args)
   {
      TicTacToe game = new TicTacToe();
      game.set(0, 0, "x");
      game.set(2, 0, "o");
      game.set(1, 1, "x");
      game.set(2, 1, "o");
      
      System.out.println("Winner: " + game.getWinner());
      System.out.println("Expected: ");
      game.set(2, 2, "x");
      System.out.println("Winner: " + game.getWinner());
      System.out.println("Expected: x");

      game = new TicTacToe();
      game.set(0, 0, "x");
      game.set(2, 0, "o");
      game.set(1, 1, "x");
      game.set(2, 1, "o");      game.set(2, 2, "o");
      System.out.println("Winner: " + game.getWinner());
      System.out.println("Expected: o");            
   }
}
