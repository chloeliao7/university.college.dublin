/**
   This class simulates a cannonball fired up in the air.
*/
public class Cannonball
{
   // private implementation
   . . .

   /**
      Creates a Cannonball object at position 0.
      @param ivel the inital velocity
   */
   public Cannonball(double ivel) { . . . }

   /**
      Updates the position and velocity of this cannon ball 
      after a given time interval.
      @param deltaT the time interval
   */
   public void move(double deltaT) { . . . }

   /**
      Gets the velocity of this cannon ball.
      @return the velocity
   */
   public double getVelocity() { . . . }

   /**
      Gets the position of this cannon ball.
      @return the (vertical) position
   */
   public double getPosition() { . . . }
}
