/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester2
{
   public static void main(String[] args)
   {
      // tax rate of 10%
      CashRegister register = new CashRegister(10);

      register.recordPurchase(29.50);
      register.recordTaxablePurchase(10.00);
      register.recordTaxablePurchase(2.00);
      register.recordPurchase(2.00);

      System.out.println(register.getTotalTax());
      System.out.println("Expected: 1.20");

      register.enterPayment(50);

      double change = register.giveChange();

      System.out.println(change);      
      System.out.println("Expected: 5.30");          
   }
}
