import java.util.Random;

/**
   This class analzyes a set of 100 random data.
*/
public class RandomDataAnalyzer
{
   public static void main(String[] args)
   {
      DataSet a = new DataSet();
      Random generator = new Random();
      
      for (int i = 0; i < 100; i++)
      {
         /* Generate a random number between 0 and 1000, 
            and add it to the set 
         */
         a.add(generator.nextDouble() * 1000); 
      }

      System.out.println("Average: " + a.getAverage());
      System.out.println("Maximum: " + a.getMaximum());
   }
}
