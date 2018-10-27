public class MockText implements IText
{
   private int section;
   private String[] sectionTypes = 
   {
      "h1", "p", "p"
   };
   private String[] sections = 
   { 
      "Chapter 1",
      "Happy families are all alike; every unhappy family is unhappy in\n" 
      + "its own way.",
      "Everything was in confusion in the Oblonskys' house. The wife\n"
      + "had discovered that the husband was carrying on an intrigue with\n"
      + "a French girl, who had been a governess in their family, and she\n"
      + "had announced to her husband that she could not go on living in\n"
      + "the same house with him ..."
   };   

   /**
      Checks whether there is another segment
      @return true if there is another segment
   */
   public boolean hasMoreSegments()
   {
      return section < sections.length;
   }

   /**
      Gets the type of the next segment
      @return the type such as p or h1
   */
   public String nextSegmentType()
   {
      return sectionTypes[section];
   }

   /**
      Reads the text of the next segment
      @return the text of the next segment
   */
   public String nextSegment()
   {
      String result= sections[section];
      section++;
      return result;
   }
}
