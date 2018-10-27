/**
  Class TaxReturn is used to determine the tax amount for a person.
*/
public class TaxReturn
{
   public static final int SINGLE = 1;
   public static final int MARRIED = 2;
   
   private static final double RATE1 = 0.15;
   private static final double RATE2 = 0.28;
   private static final double RATE3 = 0.31;

   private static final double SINGLE_BRACKET1 = 21450;
   private static final double SINGLE_BRACKET2 = 51900;

   private static final double MARRIED_BRACKET1 = 35800;
   private static final double MARRIED_BRACKET2 = 86500;

   private double income;
   private int status;

   /**
      Constructs a TaxReturn object for a given income and
      marital status.
      @param anIncome the taxpayer income
      @param aStatus either SINGLE or MARRIED
   */
   public TaxReturn(double anIncome, int aStatus)
   {
      income = anIncome;
      status = aStatus;
   }

   /**
     Method used to calculate the tax.
     @return the tax amount
   */
   public double getTax()
   {
      double tax = 0;
      double bracket1;
      double bracket2;

      if (status == SINGLE)
      {
         bracket1 = SINGLE_BRACKET1;
         bracket2 = SINGLE_BRACKET2;
      }
      else /* status is MARRIED */
      {
         bracket1 = MARRIED_BRACKET1;
         bracket2 = MARRIED_BRACKET2;
      }

      if (income < bracket1)
         tax = RATE1 * income;
      else if (income < bracket2)
         tax = RATE1 * bracket1 + (income - bracket1) * RATE2;
      else
         tax = RATE1 * bracket1 + RATE2 * (bracket2 - bracket1)
             + RATE3 * (income - bracket2);

      return tax;
   }
}
