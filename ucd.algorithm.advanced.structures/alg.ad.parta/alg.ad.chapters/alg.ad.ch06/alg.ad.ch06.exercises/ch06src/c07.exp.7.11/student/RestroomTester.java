public class RestroomTester
{
   public static void main(String[] args)
   {
      int STALLS = 12;
      Restroom wc = new Restroom(STALLS);
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: ______X_____");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: ___X__X_____");
   }
}
