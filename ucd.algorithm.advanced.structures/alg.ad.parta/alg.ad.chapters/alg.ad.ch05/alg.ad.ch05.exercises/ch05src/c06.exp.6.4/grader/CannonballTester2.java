public class CannonballTester2
{
   public static void main(String[] args)
   {
      Cannonball ball = new Cannonball(50); // 50 m/sec
      ball.move(1); // move by one second

      System.out.println(ball.getPosition());
      System.out.println("Expected: 50");      
      System.out.println(ball.getVelocity());
      System.out.println("Expected: " + (50 - 9.81));
      
      ball.move(1); 
      System.out.println(ball.getPosition());
      System.out.println("Expected: " + (50 + 50 - 9.81));
      System.out.println(ball.getVelocity());
      System.out.println("Expected: " + (50 - 9.81 - 9.81));      
   }
}
