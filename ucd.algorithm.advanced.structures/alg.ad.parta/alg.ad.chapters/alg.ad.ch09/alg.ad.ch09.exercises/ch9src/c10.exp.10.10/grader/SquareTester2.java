/**
   This class tests the Square class.
*/
public class SquareTester2
{
   public static void main(String[] args)
   {
      Square sq = new Square(50, 50, 10);
      System.out.println(sq.toString());
      System.out.println("Expected: Square[x=45,y=45,width=10,height=10]");
      System.out.println("Area: " + sq.getArea());
      System.out.println("Expected: 100");

      sq = new Square(0, 0, 20);
      System.out.println(sq.toString());
      System.out.println("Expected: Square[x=-10,y=-10,width=20,height=20]");
      System.out.println("Area: " + sq.getArea());
      System.out.println("Expected: 400");      
      
   }
}
