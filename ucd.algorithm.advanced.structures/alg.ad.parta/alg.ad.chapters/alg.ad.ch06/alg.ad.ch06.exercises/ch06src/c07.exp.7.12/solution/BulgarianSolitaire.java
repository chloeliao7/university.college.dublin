import java.util.ArrayList;
import java.util.Random;


/**
   A class that plays Bulgarian Solitare. The game starts
   with 45 cards. (They need not be playing cards. Unmarked
   index cards work just as well.) Randomly divide them into
   some number of piles of random size. For example, you might
   start with piles of size 20, 5, 1, 9, and 10. In each round,
   you take one card from each pile, forming a new pile with
   these cards. For example, the sample starting configuration
   would be transformed into piles of size 19, 4, 8, 9, and 5.
   The solitaire is over when the piles have size
   1, 2, 3, 4, 5, 6, 7, 8, and 9, in some order.
   (It can be shown that you always end up with such a configuration.)
*/

public class BulgarianSolitaire
{
   private ArrayList<Integer> piles;

   /**
      Sets up the game randomly with some number of piles of random
      size. The pile sizes add up to 45.
   */
   public void setupRandomly()
   {
      piles = new ArrayList<Integer>();
      /* randomly divide up the deck into piles */
      int TOTAL_SIZE = 45;  // number of cards in a deck
      Random rand = new Random();
      int numCards = TOTAL_SIZE;
      while (numCards > 0)
      {
         int deal = rand.nextInt(numCards) + 1;
         piles.add(deal);
         numCards -= deal;
      }
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
      /* the number of cards that will end up in the last pile to be added */
      int newPile = piles.size();

      for (int i = 0; i < piles.size(); i++)
      {
          int val = piles.get(i);
          val--;
          if (val > 0)
             piles.set(i, val);
          else
          {
             piles.remove(i);
             i--;   // must adjust for removed element
          }
      }

      piles.add(newPile);   // add new pile at end   
   }

   /**
      Checks whether the game is done.
      @return true when the piles have size 
      1, 2, 3, 4, 5, 6, 7, 8, and 9, in some order.
   */
   public boolean isDone()
   {
      /*
         We are done when we have some combination of the numbers
         1 through 9 in the piles. Therefore, we can first check to
         make sure we have exactly 9 piles so we don't waste our time.
         We also need to take care that we have the exact numbers and
         avoid a situation like  1 1 3 4 5 6 7 8 10  which means we
         still aren't done.
      */
      
      /* if there are more or less than 9 piles, we cannot be done */
      if (piles.size() != 9)
         return false;

      /* test for the numbers 1 through 9 */
      boolean test[] = new boolean[10];

      for (Integer e : piles)
      {
         if (e > 9)   // we aren't done
            return false;

         if (!test[e])  // we haven't seen this number yet
            test[e] = true;
         else // duplicate value, we aren't done
            return false;
      }

      /* if we are here, we have the numbers 1 through 9
         in some order in the array list, so we are done */
      return true;
   }
}
