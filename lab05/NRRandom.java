import java.util.*;
public class NRRandom extends Random {
    // create temporary value to store previous value
    private int temp = -1;

    // constructor to handle the transition from Random to NRRandom
    public NRRandom(long seed) {
      super(seed);
    }

    // modifies the nextInt function for our new NRRandom class
    public int nextInt(int bound) {
      int val = super.nextInt(bound);
      // check loop
      // add base case within the check
      while (val == temp && temp != -1) {
        val = super.nextInt(bound);
      }
      // modify and return
      temp = val;
      return val;
    }
}
