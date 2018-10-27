public interface Filter 
{   
   /**
      Determines whether to accept an object.
      @param x the object to be filtered
      @return true to accept an object, false otherwise
   */
   boolean accept(Object x);   
}
