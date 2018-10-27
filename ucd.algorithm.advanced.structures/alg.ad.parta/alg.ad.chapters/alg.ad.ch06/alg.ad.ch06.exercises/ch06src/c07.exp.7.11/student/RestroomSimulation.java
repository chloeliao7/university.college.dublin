/**
      Print diagrams of restroom stalls as they are occupied.
      The premise is that people generally prefer to maximize
      their distance from already occupied stalls, by occupying
      the middle of the longest sequence of unoccupied places.
*/

public class RestroomSimulation
{
   public static void main(String[] args)
   {
      int STALLS = 10;
      Restroom wc = new Restroom(STALLS);

      for (int i = 1; i <= STALLS; i++)
      {
         wc.addOccupant();
         System.out.println(wc.getStalls());
      }
   }
}
