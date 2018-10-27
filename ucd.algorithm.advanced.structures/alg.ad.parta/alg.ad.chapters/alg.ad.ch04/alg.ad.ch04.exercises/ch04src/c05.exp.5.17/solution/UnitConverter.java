/**
   This class implements a unit converter that converts between a given
   length unit and meters.
*/
public class UnitConverter
{
   final double INCH_TO_METER = 0.0254;
   final double FOOT_TO_METER = 0.305;
   final double MILE_TO_METER = 1609;

   private double factor;

   /**
      Constructs a unit converter to convert between a unit and meters
      @param unit the unit used by this converter
   */
   public UnitConverter(String unit)
   {
      if (unit.equals("in"))
         factor = INCH_TO_METER;
      else if (unit.equals("ft"))
         factor = FOOT_TO_METER;
      else if (unit.equals("mi"))
         factor = MILE_TO_METER;
      else if (unit.equals("mm"))
         factor = 0.001;
      else if (unit.equals("cm"))
         factor = 0.01;
      else if (unit.equals("m"))
         factor = 1;
      else if (unit.equals("km"))
         factor = 1000;
      else
         factor = 1;
   }

   /**
      Converts a measurement to meters.
      @param measurement a measurement in the units of this converter      
      @return the equivalent meters
   */
   public double toMeters(double measurement)
   {
      return measurement * factor;
   }

   /**
      Converts a measurement from meters.
      @param measurement the measurement to convert from meters
      @return the equivalent value in the unit of this converter
   */
   public double fromMeters(double measurement)
   {
      return measurement / factor;
   }
}
