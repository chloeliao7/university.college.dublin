/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();

      // transaction #1
      register.recordPurchase(30);
      register.recordPurchase(10);
      register.enterPayment(50);

      double change = register.giveChange();
      System.out.println(change);
      System.out.println("Expected: ...");

      // transaction #2
      register.recordPurchase(20);
      register.enterPayment(20);

      change = register.giveChange();
      System.out.print("Change: ");
      System.out.println(change);
      System.out.println("Expected: ...");

      // test new functionality
      System.out.print("Total: ");
      System.out.println(register.getSalesTotal());
      System.out.println("Expected: ...");

      System.out.print("Count: ");
      System.out.println(register.getSalesCount());
      System.out.println("Expected: 2");

      register.reset();
      System.out.print("Total: ");
      System.out.println(register.getSalesTotal());
      System.out.println("Expected: ...");

      System.out.print("Count: ");
      System.out.println(register.getSalesCount());
      System.out.println("Expected: ...");
   }
}
