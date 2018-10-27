/**
   This program tests the use of a Measurer and a Filter.
*/
public class DataSetTester2
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
      
      data.add(new BankAccount(10000));
      data.add(new BankAccount(100));
      data.add(new BankAccount(20));
      data.add(new BankAccount(999.99));
      data.add(new BankAccount(4000));

      System.out.println("Average balance: " + data.getAverage());
      System.out.println("Expected: 7000");

      BankAccount b = (BankAccount) data.getMaximum();
      double balance = b.getBalance();
      System.out.println("Highest balance: " + balance);      
      System.out.println("Expected: 10000");
   }
}
