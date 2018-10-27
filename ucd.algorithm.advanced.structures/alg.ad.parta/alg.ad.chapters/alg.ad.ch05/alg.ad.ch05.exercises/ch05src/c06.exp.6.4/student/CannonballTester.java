public class CannonballTester
{
   public static void main(String[] args)
   {
      Cannonball ball = new Cannonball(100); // 100 m/sec
      ball.move(1); // move by one second

      System.out.println(ball.getPosition());
      System.out.println("Expected: 100");      
      System.out.println(ball.getVelocity());
      System.out.println("Expected: " + (100 - 9.81));
   }
}
