/**
   Tests the game of Bulgarian Solitaire.
*/
public class BulgarianSolitaireTester
{
   public static void main(String[] args)
   {
      BulgarianSolitaire deck = new BulgarianSolitaire();
      int[] initialSizes = { 20, 5, 1, 9, 10 };
      deck.setup(initialSizes);
      System.out.println(deck.isDone());
      System.out.println("Expected: false");
      deck.playRound();
      System.out.println(deck.getPiles());
      System.out.println("Expected: [19, 4, 8, 9, 5]");
   }
}
