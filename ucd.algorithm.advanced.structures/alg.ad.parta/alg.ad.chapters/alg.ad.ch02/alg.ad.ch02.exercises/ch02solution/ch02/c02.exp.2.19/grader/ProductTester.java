/**
   This program demonstrates the Product class.
*/
public class ProductTester
{  
   public static void main(String[] args)
   {  
      Product product1 = new Product("Toaster", 29.95);

      System.out.print("name: ");
      System.out.println(product1.getName());
      System.out.println("Expected: Toaster");

      System.out.print("price: ");
      System.out.println(product1.getPrice());
      System.out.println("Expected: 29.95");      

      product1.reducePrice(5);
      product1.reducePrice(5);

      System.out.print("price: ");
      System.out.println(product1.getPrice());
      System.out.println("Expected: 19.95");      
   }
}
