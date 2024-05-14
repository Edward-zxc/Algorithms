import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
  /**
   * Reads a sequence of words from standard input
   * and prints one of those words uniformly at random.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    String champion = "";
    double i = 0;
    while (!StdIn.isEmpty()) {
      String tmp = StdIn.readString();
      i++;
      if (StdRandom.bernoulli(1.0 / i)) {
        champion = tmp;
      }
    }
    StdOut.println(champion);
  }
}
