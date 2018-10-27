public class TicTacToeStrategyTester
{
   public static void main(String[] args)
   {
      ITicTacToeStrategy strategy = new MockTicTacToeStrategy();
      TicTacToeBoard board = new TicTacToeBoard();
      board.makeMove("1 1", "x");
      String move = strategy.getMove(board);
      System.out.println(move);
      System.out.println("Expected: 1 2");
      board.makeMove(move, "o");
      board.makeMove("1 3", "x");
      move = strategy.getMove(board);
      System.out.println(move);
      System.out.println("Expected: 2 1");
   }
}
