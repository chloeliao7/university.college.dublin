/**
   A class that shows how restroom stalls are occupied.
*/

public class Restroom
{
   private boolean stalls[];

   /**
      Constructs a restroom with a given number of stalls.
      @param ns the number of stalls
   */
   public Restroom(int ns)
   {
		stalls = new boolean[ns];
   }

   /*
      Adds an occupant in the middle of the longest sequence of
      unoccupied places. 
   */
   public void addOccupant()
   {
      int longestIndex = -1;  // first stall in longest unoccupied sequence
      int longest = 0;   // number of stalls in longest unoccupied sequence
      int countIndex = -1; // index of current sequence of unoccupied stalls
      int count = 0;   // number of current sequence of unoccupied stalls

      /* if the first stall is unoccupied, start a sequence */
      if (!stalls[0])
      {
         longestIndex = 0;
         longest = 1;
         countIndex = 0;
         count = 1;
      }

      /* look for runs of empty stalls, tracking the longest */
      for (int i = 1; i < stalls.length; i++)
      {
         /* this stall is occupied */
         if (stalls[i])
         {
            /* end the run? */
            if (!stalls[i-1])
            {
               if (count > longest)
               {
                  longest = count;
                  longestIndex = countIndex;
               }
            }
            count = 0;
         }
          /* this stall is unoccupied */
         else
         {
            /* are we in the middle of a run of unoccupied stalls? */
            if (!stalls[i-1])   // yes
               count++;
            else   // no
            {
               count = 1;
               countIndex = i;
            }
         }
      } // for

      /* final check for case when longest sequence is at the end */
      if (count > longest)
      {
         longest = count;
         longestIndex = countIndex;
      }

      stalls[longestIndex + (longest / 2)] = true;
   }

   /*
      Gets a string describing the current stall occupation
      @return a string with _ for an empty stall and X for an occupied one
   */
   public String getStalls()
   {
      String r = "";
      for (boolean b : stalls)
      {
         if (b) r = r + "X"; else r = r + "_";
      }
      return r;
   }
}
