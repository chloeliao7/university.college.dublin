/**
   Tests the savings account class.
*/
public class SavingsAccountTester
{  
   public static void main(String[] args)
   {  
      SavingsAccount momsSavings = new SavingsAccount(1000, 10);
      
      momsSavings.addInterest();
      momsSavings.addInterest();
      momsSavings.addInterest();
      momsSavings.addInterest();
      momsSavings.addInterest();
      
      double balance = momsSavings.getBalance();
      
      System.out.print("Balance: ");
      System.out.println(balance);
      System.out.println("Expected: 1610.51");
   }
}
