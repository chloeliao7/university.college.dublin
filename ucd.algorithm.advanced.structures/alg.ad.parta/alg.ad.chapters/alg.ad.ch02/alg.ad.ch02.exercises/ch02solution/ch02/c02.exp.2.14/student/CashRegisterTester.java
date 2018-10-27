/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      // tax rate of 5%
      CashRegister register = new CashRegister(5);

      register.recordPurchase(29.50);
      register.recordTaxablePurchase(10.00);
      register.recordTaxablePurchase(2.00);

      System.out.println(register.getTotalTax());
      System.out.println("Expected: 0.60");

      register.enterPayment(50);

      double change = register.giveChange();

      System.out.println(change);      
      System.out.println("Expected: 7.90");          
   }
}
