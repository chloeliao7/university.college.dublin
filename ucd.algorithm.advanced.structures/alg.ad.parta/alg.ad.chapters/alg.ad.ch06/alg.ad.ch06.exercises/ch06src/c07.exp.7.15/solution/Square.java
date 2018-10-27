import java.util.ArrayList;

/**
   A magic square is an n x n matrix which, if filled with numbers,
   the sum of the elements in each row, each column, 
   and the two diagonal is the same value.
*/
public class Square
{  
   private ArrayList<Integer> numbers;
   private int[][] square;
   private int size;

   /**
      Construct a Square object.
      @param none
   */
   public Square()
   {  
      numbers = new ArrayList<Integer>();
   }

   /**
      Add a number to the ArrayList of values.
      @param val the number to add
   */
   public void add(int val)
   {
      numbers.add(val);
   }

   /**
      Add the numbers in a row of the square.
      @param i the row index
      @return the sum of the row
   */
   public int rowSum(int i)
   {  
      int sum = 0;
      for (int j = 0; j < size; j++)
      {  
         sum = sum + square[i][j];
      }
      return sum;
   }

   /**
      Add the numbers in a column of the square.
      @param i the column index
      @return the sum of the column
   */
   public int columnSum(int i)
   {  
      int sum = 0;
      for (int j = 0; j < size; j++)
      {  
         sum = sum + square[j][i];
      }
      return sum;
   }

   /**
      Find the sum of the diagonal.
      @param mainDiagonal true if it is the main diagonal
      @return sum the sum of the diagonal
   */
   public int diagonalSum(boolean mainDiagonal)
   {  
      int sum = 0;
      for (int i = 0; i < size; i++)
      {  
         int j;
         if (mainDiagonal) 
            j = i; 
         else 
            j = size - 1 - i;
         sum = sum + square[i][j];
      }
      return sum;
   }

   /** 
      Determine if the square is a magic square.
      @return true if square is a magic square, false otherwise
   */
   public boolean isMagic()
   {  
      /*
         Start by checking if the input set is square.
      */
      size = (int) Math.sqrt(numbers.size());
      if (size * size != numbers.size())
         return false;

      /*
         Now put numbers into a square for further work.
      */
      square = new int[size][size];

      for (int i = 0; i < size ; i++)
         for (int j = 0; j < size ; j++)
            square[i][j] = numbers.get(i * size + j);

      /*
         Next check to see if each of the numbers 1, 2, ... n^2
         appear once in the input.
      */
      for (int n = 1; n <= size * size; n++)
      {
         if (numbers.indexOf(n) == -1)
            return false;
      }

      /*
         Check the diagonal sums.
      */      
      int sum = diagonalSum(true);
      
      if (sum != diagonalSum(false)) 
         return false;

      /*
         Check all of the rows and columns.
      */
      for (int i = 0; i < size; i++)
      {  
         if (sum != rowSum(i)) 
            return false;
         
         if (sum != columnSum(i)) 
            return false;
      }

      return true;
   }
}
