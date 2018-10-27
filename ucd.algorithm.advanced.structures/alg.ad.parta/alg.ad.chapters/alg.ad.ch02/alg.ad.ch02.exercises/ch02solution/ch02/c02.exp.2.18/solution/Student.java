/**
   A student who is taking quizzes.
*/
public class Student
{ 
   private String name;
   private double totalScore;
   private int quizCount;

   /**
      Constructs a student with a given name.
      @param n the name
   */
   public Student(String n)
   {  
      name = n;
      totalScore = 0;
      quizCount = 0;
   }

   /**
      Gets the name of this student.
      @return the name
   */
   public String getName()
   {  
      return name;
   }

   /**
      Adds a quiz score.
      @param the score to add
   */
   public void addQuiz(int score)
   {  
      totalScore = totalScore + score;
      quizCount = quizCount + 1;
   }


   /**
      Gets the sum of all quiz scores.
      @return the total score
   */
   public double getTotalScore()
   {  
      return totalScore;
   }

   /**
      Gets the average of all quiz scores.
      @return the average score
   */
   public double getAverageScore()
   {  
      return totalScore / quizCount;
   }
}

