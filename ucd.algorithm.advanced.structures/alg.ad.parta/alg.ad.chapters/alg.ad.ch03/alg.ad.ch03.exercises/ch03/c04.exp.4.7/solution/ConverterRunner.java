import java.util.Scanner;

/**
   This program tests the Converter class.
 */
public class ConverterRunner
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter a distance in meters: ");
      double meters = in.nextDouble();
   
      final double MILE_TO_KM = 1.609;
      final double METER_TO_FT = 3.2808399;
      final double FT_TO_IN = 12;

      Converter milesToMeters = new Converter(1000 * MILE_TO_KM);
      Converter metersToFeet = new Converter(METER_TO_FT);
      Converter feetToInches = new Converter(FT_TO_IN);            
    
      System.out.println("miles: " + milesToMeters.convertFrom(meters));
      double feet = metersToFeet.convertTo(meters);
      System.out.println("feet: " + feet);
      System.out.println("inches: " + feetToInches.convertTo(feet));   
   }
}
