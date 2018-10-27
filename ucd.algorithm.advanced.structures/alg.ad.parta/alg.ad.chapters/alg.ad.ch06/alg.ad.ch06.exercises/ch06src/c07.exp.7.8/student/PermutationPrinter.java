/**
   This class prints 5 permutations of the numbers 1 through 10.
*/
public class PermutationPrinter
{  
   public static void main(String[] args)
   {  
      PermutationGenerator gen = new PermutationGenerator(10);      
      
      for (int i = 1; i <= 5; i++)
      {  
         for (int n : gen.nextPermutation())
            System.out.print(" " +  n);
         System.out.println();
      }
   }
}
