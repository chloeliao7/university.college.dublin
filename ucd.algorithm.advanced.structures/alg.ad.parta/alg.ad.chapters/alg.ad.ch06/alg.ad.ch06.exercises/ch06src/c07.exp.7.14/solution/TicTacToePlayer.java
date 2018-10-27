import java.util.Scanner;

/**
   This program plays a game of TicTacToe.
*/
public class TicTacToePlayer
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      String player = "x";
      TicTacToe game = new TicTacToe();
      
      boolean done = false;
      while (!done)
      {
         System.out.println(game); // calls game.toString()
         System.out.println("Row for " + player + " (Q to exit): ");
         String input = in.next();
         
         if (input.equalsIgnoreCase("Q")) 
            done = true;
         else
         {
            int row = Integer.parseInt(input);
            System.out.println("Column for " + player + ": ");
            int column = in.nextInt();
         
            game.set(row, column, player);
         
            if (player.equals("x"))
               player = "o"; 
            else player = "x";  
         
            String winner = game.getWinner();
         
            if (!winner.equals(" "))
            {
               System.out.println(game);
               System.out.println("The winner is " + winner + "!");
               done = true;
            }
         }
      }
   }
}
