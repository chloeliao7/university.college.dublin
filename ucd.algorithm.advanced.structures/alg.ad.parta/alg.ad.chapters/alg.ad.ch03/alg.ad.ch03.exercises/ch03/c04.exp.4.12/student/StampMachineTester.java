import java.util.Scanner;

public class StampMachineTester
{
   public static void main(String[] args)
   {
      StampMachine machine = new StampMachine();
      machine.insert(1);
      System.out.print("First class stamps: "); 
      System.out.println(machine.giveFirstClassStamps());
      System.out.println("Expected: 2");
      System.out.print("Penny stamps: "); 
      System.out.println(machine.givePennyStamps());
      System.out.println("Expected: 12");
   }
}
