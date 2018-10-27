/**
   This class tests the Square class.
*/
public class SquareTester
{
   public static void main(String[] args)
   {
      Square sq = new Square(10, 20, 30);
      System.out.println(sq.toString());
      System.out.println("Expected: Square[x=-5,y=5,width=30,height=30]");
      System.out.println("Area: " + sq.getArea());
      System.out.println("Expected: 900");
   }
}
