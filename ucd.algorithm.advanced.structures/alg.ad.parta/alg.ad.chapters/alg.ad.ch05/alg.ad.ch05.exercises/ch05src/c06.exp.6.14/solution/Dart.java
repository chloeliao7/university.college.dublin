import java.util.Random;

/**
   This class implements the throwing of a dart to approximate pi.
*/
public class Dart
{
   private Random generator;
   private int hits;
   private int tries;

   /**
      Creates a Dart object.
   */
   public Dart()
   {
      generator = new Random();
      hits = 0;
      tries = 0;
   }

   /**
      Throws a dart into the square [-1,1] x [1,1] and records
      whether it hits the unit circle.
   */
   public void throwIntoSquare()
   {
      double x = -1 + 2 * generator.nextDouble();
      double y = -1 + 2 * generator.nextDouble();

      if (x * x + y * y <= 1)
         hits++;

      tries++;
   }

   /**
      Get the number of hits inside the unit circle.
      @return hits number of hits
   */
   public int getHits()
   {
      return hits;
   }

   /**
      Get the number of tries.
      @return the number of times the dart was thrown.
   */
   public int getTries()
   {
      return tries;
   }
}
