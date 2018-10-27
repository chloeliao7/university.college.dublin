public class HourlyEmployee extends Employee
{
   private double hourlyWage;

   public HourlyEmployee(String name, double wage)
   {
      setName(name);
      hourlyWage = wage;
   }
 
   public double weeklyPay(int hoursWorked)
   {
      double pay = hoursWorked * hourlyWage;
      if (hoursWorked > 40)
      {
         pay = pay + ((hoursWorked - 40) * 0.5) * hourlyWage;
      }
      return pay;
   }
}

