public class Manager extends SalariedEmployee
{
   private double weeklyBonus;

   public Manager(String name, double salary, double bonus)
   {
      super(name, salary);
      weeklyBonus = bonus;
   }

   public double weeklyPay(int hours)
   {
      return super.weeklyPay(hours) + weeklyBonus;
   }
}


