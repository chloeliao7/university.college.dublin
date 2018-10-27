/**
   This class simulates a cannonball fired up in the air.
*/
public class Cannonball
{
   private static final double G = 9.81;

   private double ivel;
   private double pos;

   /**
      Creates a Cannonball object.
      @param aIvel the inital velocity
   */
   public Cannonball(double aIvel)
   {
      ivel = aIvel;
      pos = 0;
   }

   /**
      Updates the position and velocity of this cannon ball 
      after a given time interval.
      @param deltaT the time interval
   */
   public void move(double deltaT)
   {
      pos = pos + ivel * deltaT;
      ivel = ivel - G * deltaT;
   }

   /**
      Gets the velocity of this cannon ball.
      @return the velocity
   */
   public double getVelocity()
   {
      return ivel;
   }

   /**
      Gets the position of this cannon ball.
      @return the (vertical) position
   */
   public double getPosition()
   {
      return pos;
   }
}
