/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester2
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();

      // transaction #1
      register.recordPurchase(29.50);
      register.recordPurchase(9.25);
      register.recordPurchase(1.25);
      register.enterPayment(50);

      double change = register.giveChange();

      // transaction #2
      register.recordPurchase(19.50);
      register.enterPayment(20);

      change = register.giveChange();

      // transaction #3
      register.recordPurchase(25.25);
      register.enterPayment(30.25);

      change = register.giveChange();

      // test new functionality
      System.out.println(register.getSalesTotal());
      System.out.println("Expected: 84.75");

      System.out.println(register.getSalesCount());
      System.out.println("Expected: 3");

      register.reset();
      System.out.println(register.getSalesTotal());
      System.out.println("Expected: 0");

      System.out.println(register.getSalesCount());
      System.out.println("Expected: 0");

   }
}
