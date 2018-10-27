import java.util.Scanner;

/**
   Test driver class for Cannonball class.
*/
public class CannonballRunner
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.print("Enter the initial velocity: ");
      double ivel = in.nextDouble();

      final double G = 9.81;
      double deltaT = 0.01;
      double t = 0;
      double exactPos = 0;
      double vel = ivel;
      int steps = 0;

      Cannonball cb = new Cannonball(ivel);

      do
      {
         cb.move(deltaT);
         t = t + deltaT;
         vel = cb.getVelocity();
         steps++;
         exactPos = -0.5 * G * t * t + ivel * t;
         if (steps % 100 == 0) 
         {   
            System.out.println("Simulation position: " + cb.getPosition()
               + " Velocity: " + cb.getVelocity());
            System.out.println("The exact formula position is: " + exactPos);
         }
      }
      while (exactPos > 0);
   }
}
