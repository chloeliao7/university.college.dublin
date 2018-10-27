public class RoachPopulation
{
   private int pop;

   public RoachPopulation(int initialPopulation)
   {
      pop = initialPopulation;
   }
   
   public void doublePopulation()
   {
      pop = pop * 2;
   }
   
   public int getPopulation()
   {
      return pop;
   }
}
