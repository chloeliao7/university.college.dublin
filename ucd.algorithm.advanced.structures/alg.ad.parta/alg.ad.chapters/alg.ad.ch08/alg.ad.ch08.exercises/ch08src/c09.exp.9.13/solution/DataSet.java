/**
   Computes the minimum and maximum of a set of data values.
*/
public class DataSet
{
   private Comparable minimum;
   private Comparable maximum;

   /**
      Constructs an empty data set.
   */
   public DataSet()
   {
      maximum = null;
      minimum = null;
   }

   /**
      Adds a data value to the data set.
      @param x a data value
   */      
   public void add(Comparable x) 
   { 
      if(minimum == null || x.compareTo(minimum) < 0) 
         minimum = x; 
      if(maximum == null || x.compareTo(maximum) > 0) 
         maximum = x; 
   }     

   /**
      Gets the largest of the added data.
      @return the maximum or null if no data has been added
   */
   public Comparable getMaximum()
   {
      return maximum;
   }
   
   /**
      Gets the largest of the added data.
      @return the maximum or null if no data has been added
   */
   public Comparable getMinimum()
   {
      return minimum;
   }   
}
