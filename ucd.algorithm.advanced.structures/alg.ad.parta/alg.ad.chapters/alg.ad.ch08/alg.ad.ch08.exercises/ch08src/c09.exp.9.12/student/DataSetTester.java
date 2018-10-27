/**
   This program tests the use of a Measurer and a Filter.
*/
public class DataSetTester
{
   public static void main(String[] args)
   {
      class BankMeasurer implements Measurer
      {         
         public double measure(Object anObject)
         {
            BankAccount ba = (BankAccount) anObject;
            return ba.getBalance();
         }         
      }
      
      class BankFilter implements Filter
      {
         public boolean accept(Object x)
         {
            BankAccount ba = (BankAccount) x;
            return ba.getBalance() > 1000;
         }        
      }
      
      Measurer m = new BankMeasurer();
      Filter f = new BankFilter();
      DataSet data = new DataSet(m, f);
      
      data.add(new BankAccount(1));
      data.add(new BankAccount(100));
      data.add(new BankAccount(2000));
      data.add(new BankAccount(950));
      data.add(new BankAccount(4000));

      System.out.println("Average balance: " + data.getAverage());
      System.out.println("Expected: 3000");

      BankAccount b = (BankAccount) data.getMaximum();
      double balance = b.getBalance();
      System.out.println("Highest balance: " + balance);      
      System.out.println("Expected: 4000");
   }
}
