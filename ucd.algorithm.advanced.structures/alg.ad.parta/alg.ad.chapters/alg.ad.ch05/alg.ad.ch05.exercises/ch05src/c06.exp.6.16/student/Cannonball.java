/**
   This class simulates a cannonball fired at an angle.
*/
public class Cannonball
{
   // private implementation
   . . .

   /**
      Constructs a Cannonball 
      @param ivel the initial velocity of the ball
      @param angle the angle at which the cannonball was launched
      (in degrees)
   */
   public Cannonball(double ivel, double angle) { . . . }

   /**
      Updates the position and velocity of this cannon ball 
      after a given time interval.
      @param deltaT the time interval
   */
   public void move(double deltaT) { . . . }

   /**
      Gets the x position of this cannon ball.
      @return the horizontal position
   */
   public double getX() { . . . }

   /**
      Gets the y position of this cannon ball.
      @return the vertical position
   */
   public double getY() { . . . }
}
