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
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: ___X__X__X__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X__X__X__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X_XX__X__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X_XX_XX__");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: _X_X_XX_XX_X");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: XX_X_XX_XX_X");
      wc.addOccupant();
      System.out.println(wc.getStalls());
      System.out.println("Expected: XXXX_XX_XX_X");
   }
}
