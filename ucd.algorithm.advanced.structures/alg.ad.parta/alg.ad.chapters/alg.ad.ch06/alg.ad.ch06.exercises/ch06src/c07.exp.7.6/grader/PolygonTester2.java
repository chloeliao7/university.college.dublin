/**
   This is a tester class for Polygon.
*/
public class PolygonTester2
{
   public static void main(String[] args)
   {
      Polygon triangle = new Polygon();
      
      triangle.add(-100, 100);
      triangle.add(-150, 150);
      triangle.add(-150, 100);
      
      Polygon shape = new Polygon();

      shape.add (30, 40);
      shape.add (70, 60);
      shape.add (50, 90);
      shape.add (90, 90);
      shape.add (130, 60);
      shape.add (110, 40);
      shape.add (70, 10);
      
      double trianglePerimeter = triangle.perimeter();
      System.out.printf("Triangle perimeter: %6.2f\n",trianglePerimeter);
      System.out.println("Expected: 170.71");

      double triangleArea = triangle.area();
      System.out.println("Triangle area: " + triangleArea);
      System.out.println("Expected: 1250.0");

      double shapePerimeter = shape.perimeter();
      System.out.printf("Polygon perimeter: %6.2f\n ",shapePerimeter);
      System.out.println("Expected: 299.06");

      double shapeArea = shape.area();
      System.out.println("Polygon area: " + shapeArea);
      System.out.println("Expected: 4100.0");
   }
}
