
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
  public static void main(String[] args) {
    if (StdIn.isEmpty()) {
            StdOut.println("No words entered");
        }
    else {
            String champion =StdIn.readString();
        int i = 0,len= args.length;
        while (i < len) {
            if (StdRandom.bernoulli(1.0/len)) {
                champion = args[i];
            }
            i++;
        }
        StdOut.println(champion);
        }
    }
}