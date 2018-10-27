/**
      Play the game of Bulgarian Solitare.
*/
public class BulgarianSolitairePlayer
{
   public static void main(String[] args)
   {
      BulgarianSolitaire deck = new BulgarianSolitaire();
      deck.setupRandomly();
      deck.play();
   }
}
