/**
   This program tests the DataSet class.
*/
public class DataSetTester2
{
   public static void main(String[] args)
   {
      DataSet bankData = new DataSet();

      bankData.add(new BankAccount(1000));
      bankData.add(new BankAccount(100));
      bankData.add(new BankAccount(100));

      System.out.println("Average balance: " 
            + bankData.getAverage());
      System.out.println("Expected: 400");
      Measurable min = bankData.getMinimum();
      System.out.println("Lowest balance: " 
         + min.getMeasure());
      System.out.println("Expected: 100");

      DataSet coinData = new DataSet();

      coinData.add(new Coin(0.25, "quarter"));
      coinData.add(new Coin(0.25, "quarter"));
      coinData.add(new Coin(0.1, "dime"));
      coinData.add(new Coin(0.1, "dime"));
      coinData.add(new Coin(0.05, "nickel"));

      System.out.println("Average coin value: " 
            + coinData.getAverage());
      System.out.println("Expected: 0.15");            
      min = coinData.getMinimum();
      System.out.println("Lowest coin value: " 
            + min.getMeasure());
      System.out.println("Expected: 0.05");            
   }
}
