
public class StampMachine {
  public static final int FIRST_CLASS_STAMP_PRICE = 44;
  private int balance;

  public StampMachine() {
    balance = 0;
  }

  public void insert(int dollars) {
    balance = balance + 100 * dollars;
  }

  public int giveFirstClassStamps() {
    int firstClassStamps = balance / FIRST_CLASS_STAMP_PRICE;
    balance = balance - firstClassStamps * FIRST_CLASS_STAMP_PRICE;
    return firstClassStamps;
  }

  public int givePennyStamps() {
    int pennyStamps = balance;
    balance = 0;
    return pennyStamps;
  }
}
