/**
   This class represents a person's name and height
*/
public class Person
{
   private String name;
   private double height;

   /**
      Constructs a Person object
      @param aName the name of the person
      @param aHeight the height of the person
   */
   public Person(String aName, double aHeight)
   {
      name = aName;
      height = aHeight;
   }
   
   /**
      Gets the name of the person
      @return name the person's name
   */
   public String getName()
   {
      return name;
   }
   
   /**
      Gets the height of the person
      @return height the person's height
   */
   public double getHeight()
   {
      return height;
   }
}
