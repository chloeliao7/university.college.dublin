/**
   A person is represented by the name and a birth year.
*/
public class Person
{
   private String name;
   private int birthYear;

   /**
      Construct a Person object.
      @param n the name of the person
      @param byear the birth year
   */
   public Person(String n, int byear)
   {
      name = n;
      birthYear = byear;
   }

   /**
      Returns the string representation of the object.
      @return a string representation of the object
   */
   public String toString()
   {
      return "Person[name=" + name + ",birthYear=" + birthYear + "]";
   }
}