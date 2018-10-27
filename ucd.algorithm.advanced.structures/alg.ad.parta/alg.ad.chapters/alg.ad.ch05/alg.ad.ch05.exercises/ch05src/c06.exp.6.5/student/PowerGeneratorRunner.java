public class PowerGeneratorRunner
{
   public static void main(String[] args)
   {
      PowerGenerator myGenerator = new PowerGenerator(10);
      for (int i = 1; i <= 12; i++)
         System.out.println(myGenerator.nextPower());      
   }
}
