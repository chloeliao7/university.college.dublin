/**
   Tests the savings account class.
*/
public class SavingsAccountTester2
{  
   public static void main(String[] args)
   {  
      SavingsAccount momsSavings = new SavingsAccount(1000, 10);
      
      System.out.println(momsSavings.getBalance());
      System.out.println("Expected: 1000");
      momsSavings.addInterest();
      System.out.println(momsSavings.getBalance());
      System.out.println("Expected: 1100");
      momsSavings.addInterest();
      System.out.println(momsSavings.getBalance());
      System.out.println("Expected: 1210");
   }
}
