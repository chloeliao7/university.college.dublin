public interface IText
{
   /**
      Checks whether there is another segment
      @return true if there is another segment
   */
   boolean hasMoreSegments();

   /**
      Gets the type of the next segment
      @return the type such as p or h1
   */
   String nextSegmentType();

   /**
      Reads the text of the next segment
      @return the text of the next segment
   */
   String nextSegment();
}
