/**
   This program prints the horoscopes for four people.
*/
public class HoroscopePrinter
{  
   public static void main(String[] args)
   {  
      Horoscope horo1 = new Horoscope(11, 1);
      System.out.println(horo1.getDescription());
      Horoscope horo2 = new Horoscope(11, 22);
      System.out.println(horo2.getDescription());
      Horoscope horo3 = new Horoscope(12, 1);
      System.out.println(horo3.getDescription());
      Horoscope horo4 = new Horoscope(12, 31);
      System.out.println(horo4.getDescription());
   }
}
