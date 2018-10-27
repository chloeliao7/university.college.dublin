/**
   This is a tester class for Polygon.
*/
public class PolygonTester
{
   public static void main(String[] args)
   {
      Polygon square = new Polygon();
      
      square.add(100, 100);
      square.add(100, 150);
      square.add(150, 150);
      square.add(150, 100);  
      
      Polygon hexagon = new Polygon();

      // construct a regular hexagon
      for (int i = 0; i < 6; i++)
      {
         double x = . . .
         double y = . . .
         hexagon.add(x, y);
      }
      
      double squarePerimeter = square.perimeter();
      System.out.println("Square perimeter: " + squarePerimeter);
      System.out.println("Expected: . . .");

      double squareArea = square.area();
      System.out.println("Square area: " + squareArea);
      System.out.println("Expected: . . .");

      double hexagonPerimeter = hexagon.perimeter();
      System.out.println("Hexagon perimeter: " + hexagonPerimeter);
      System.out.println("Expected: . . .");

      double hexagonArea = hexagon.area();
      System.out.println("Hexagon area: " + hexagonArea);
      System.out.println("Expected: . . .");
   }
}
