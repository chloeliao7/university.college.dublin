/**
   This program prints the horoscopes for two people.
*/
public class HoroscopePrinter
{  
   public static void main(String[] args)
   {  
      Horoscope horo1 = new Horoscope(11, 1);
      System.out.println(horo1.getDescription());
      Horoscope horo2 = new Horoscope(11, 22);
      System.out.println(horo2.getDescription());
   }
}
