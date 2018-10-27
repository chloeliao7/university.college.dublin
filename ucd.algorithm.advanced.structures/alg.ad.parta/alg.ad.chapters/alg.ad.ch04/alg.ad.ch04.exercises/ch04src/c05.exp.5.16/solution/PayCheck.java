/**
   This class models a paycheck.
*/
public class PayCheck
{
   private double wage;
   private double hours;

   /**
      Constructs a PayCheck for a given week.
      @param aWage is the employee's hourly wage
      @param hoursWorked is the amount of hours worked
   */
   public PayCheck(double aWage, double hoursWorked)
   {
      wage = aWage;
      hours = hoursWorked;
   }

   /**
      Gets the pay for this week
      @return the pay, including overtime if earned
   */
   public double getPay()
   {
      double pay = 0.0;

      final int OT_THRESHOLD = 40;
      final double OT_RATE = 1.5;

      if (hours > OT_THRESHOLD)
      {
         double regular_hours = OT_THRESHOLD;
         double overtime_hours = hours - OT_THRESHOLD;

         pay = regular_hours * wage + OT_RATE * overtime_hours * wage;
      }
      else
         pay = hours * wage;

      return pay;
   }
}
