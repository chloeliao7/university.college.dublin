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

      for (int i = 0; i < 6; i++)
      {
         double x = 150 + 50 * Math.cos(2 * Math.PI * i / 6);
         double y = 150 + 50 * Math.sin(2 * Math.PI * i / 6);
         hexagon.add(x, y);
      }
      
      double squarePerimeter = square.perimeter();
      System.out.println("Square perimeter: " + squarePerimeter);
      System.out.println("Expected: 200");

      double squareArea = square.area();
      System.out.println("Square area: " + squareArea);
      System.out.println("Expected: 2500");

      double hexagonPerimeter = hexagon.perimeter();
      System.out.println("Hexagon perimeter: " + hexagonPerimeter);
      System.out.println("Expected: 300");

      double hexagonArea = hexagon.area();
      System.out.println("Hexagon area: " + hexagonArea);
      // six 50-50-50 triangles, each has height 25 * Math.sqrt(3))
      System.out.println("Expected: " + 6 * 50 * 25 * Math.sqrt(3) / 2);
   }
}
