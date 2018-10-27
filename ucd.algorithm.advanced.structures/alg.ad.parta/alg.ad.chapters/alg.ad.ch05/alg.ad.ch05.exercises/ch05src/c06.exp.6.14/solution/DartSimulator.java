/**
   This program simulates throwing a dart into a square, trying to
   hit a circle.
*/
public class DartSimulator
{
   public static void main (String[] args)
   {
      Dart myDart = new Dart();
      final int TRIES = 100000;
      final double AREA_OF_SQUARE = 4.0;

      for (int i = 1; i <= TRIES; i++)
         myDart.throwIntoSquare();
      
      System.out.println("Approximation of pi = "
         + ((double) myDart.getHits() * AREA_OF_SQUARE)
         / myDart.getTries());
   }
}
