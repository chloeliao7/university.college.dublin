/**
   This class simulates a cannonball fired at an angle.
*/
public class Cannonball
{
   private static final double G = 9.81;

   private double posX;
   private double posY;
   private double velX;
   private double velY;

   /**
      Constructs a Cannonball 
      @param anIvel the initial velocity of the ball
      @param anAng the angle at which the cannonball was launched
   */
   public Cannonball(double ivel, double ang)
   {
      posX = 0;
      posY = 0;
      velX = Math.cos(Math.toRadians(ang)) * ivel;
      velY = Math.sin(Math.toRadians(ang)) * ivel;
   }

   /**
      Updates the position and velocity of this cannon ball 
      after a given time interval.
      @param deltaT the time interval
   */
   public void move(double deltaT)
   {
      posX = posX + velX * deltaT;
      posY = posY + velY * deltaT;
      velY = velY - G * deltaT;
   }

   /**
      Gets the x position of this cannon ball.
      @return the horizontal position
   */
   public double getX()
   {
      return posX;
   }

   /**
      Gets the y position of this cannon ball.
      @return the vertical position
   */
   public double getY()
   {
      return posY;
   }
}
