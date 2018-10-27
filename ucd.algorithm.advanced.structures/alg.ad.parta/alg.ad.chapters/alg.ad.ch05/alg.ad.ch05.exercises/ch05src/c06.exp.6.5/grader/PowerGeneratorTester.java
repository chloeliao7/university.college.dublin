public class PowerGeneratorTester
{
   public static void main(String[] args)
   {
      PowerGenerator myGenerator = new PowerGenerator(-1);
      System.out.println(myGenerator.nextPower());
      System.out.println("Expected: 1");
      System.out.println(myGenerator.nextPower());
      System.out.println("Expected: -1");
      System.out.println(myGenerator.nextPower());
      System.out.println("Expected: 1");
   }
}
