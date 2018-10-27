/**
   This program tests the measuring of Person objects.
*/
public class PersonTester2
{
   public static void main(String[] args)
   {
      class PersonMeasurer implements Measurer
      {
         public double measure(Object anObject)
         {
            Person aPerson = (Person) anObject;
            return aPerson.getHeight();
         }
      }
 
      Measurer m = new PersonMeasurer();

      DataSet data = new DataSet(m);

      data.add(new Person("Joe", 130));
      data.add(new Person("Chrissy", 158));
      data.add(new Person("Bobby", 175));
      data.add(new Person("Mary", 135));

      double avg = data.getAverage();
      Person max = (Person) data.getMaximum();

      System.out.println("Average height: " + avg);
      System.out.println("Expected: 149.5");
      System.out.println("Name of tallest person: " + max.getName());
      System.out.println("Expected: Bobby");
   }
}
