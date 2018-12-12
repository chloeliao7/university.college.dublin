/** Class for storing high scores in an array in non-decreasing order. */
public class Scores {
  public static final int maxEntries = 10;
  protected int numEntries;
  protected GameEntry[] entries;

  public Scores() {
    entries = new GameEntry[maxEntries];
    numEntries = 0;
  }

  public String toString() {
    String s = "[";
    for (int i = 0; i < numEntries; i++) {
      if (i > 0)
        s += ", ";
      s += entries[i];
    }
    return s + "]";
  }

  public void add(GameEntry e) {
    int newScore = e.getScore();
    if (numEntries == maxEntries) {
      if (newScore <= entries[numEntries - 1].getScore())
        return;
    } else
      numEntries++;
    int i = numEntries - 1;
    for (; (i >= 1) && (newScore > entries[i - 1].getScore()); i--)
      entries[i] = entries[i - 1];
    entries[i] = e;
  }

  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if ((i < 0) || (i >= numEntries))
      throw new IndexOutOfBoundsException("Invalid index: " + i);
    GameEntry temp = entries[i];
    for (int j = i; j < numEntries - 1; j++)
      entries[j] = entries[j + 1];
    entries[numEntries - 1] = null;
    numEntries--;
    return temp;
  }
}