import java.util.ArrayList;
import java.util.Random;

public class BulgarianSolitaire
{
   private ArrayList<Integer> piles;

   /**
      Sets up the game randomly with some number of piles of random
      size. The pile sizes add up to 45.
   */
   public void setupRandomly()
   {
      . . .
   }
   
   /**
      This method can be used to set up a pile with a known (non-random)
      configuration for testing.
      @param pileSizes an array of numbers whose sum is 45
   */
   public void setup(int[] pileSizes)
   {
      piles = new ArrayList<Integer>();
      for (int s : pileSizes)
         piles.add(s);
   }

   public String getPiles()
   {
      return piles.toString();
   }

   /**
      Play the game.
   */
   public void play()
   {
      while (!isDone())
      {
         System.out.println(getPiles());
         playRound();
      }
      System.out.println(getPiles());
   }

   /**
      Play one round of the game. 
   */
   public void playRound()
   {
      . . .
   }

   /**
      Checks whether the game is done.
      @return true when the piles have size 
      1, 2, 3, 4, 5, 6, 7, 8, and 9, in some order.
   */
   public boolean isDone()
   {
      . . .
   }
}
