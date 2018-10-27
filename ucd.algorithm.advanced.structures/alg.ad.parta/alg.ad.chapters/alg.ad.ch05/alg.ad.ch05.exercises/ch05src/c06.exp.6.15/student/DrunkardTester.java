public class DrunkardTester
{
   public static void main(String[] args)
   {      
      Drunkard d = new Drunkard(10, 10);
      d.move();
      System.out.println(d.getRow() != 10 && d.getColumn() == 10
         || d.getColumn() != 10 && d.getRow() == 10);
      System.out.println("Expected: true");
   }
}
