import si211.*;
import java.util.*;

public class TweetQueueIter extends TweetQueue {
  private int numTweets;

  public TweetQueueIter(Scanner fin) {
    super();
    numTweets = 0;
    while(fin.hasNext()) {
      this.enqueue(Tweet.read(fin));
      numTweets++;
    }
  }

  public TweetQueueIter() {
    super();
    numTweets = 0;
  }

  public int getTweets() { return numTweets; }

  public void resetNumTweets() {
    int count = 0;
    Iter itr = iterator();
    while(itr.hasNext()) {
      Tweet tweet = itr.next();
      count++;
    }

    numTweets = count;
  }

  public void printDump() {
    Iter itr = iterator();
    while(itr.hasNext()) {
      System.out.println(itr.next());
    }
    System.out.println(numTweets + " tweets");
  }

  public TweetQueueIter filter(String s) {

    numTweets = 0;
    Iter itr = iterator();
    TweetQueueIter q = new TweetQueueIter();
    while(itr.hasNext()) {
      Tweet tweet = itr.next();
      if(tweet.getText().indexOf(s) != -1) {
        numTweets++;
        q.enqueue(tweet);
      }
    }

    System.out.println(numTweets + " tweets");
    return q;
  }

  public TweetQueueIter filterNot(String s) {

    numTweets = 0;
    Iter itr = iterator();
    TweetQueueIter q = new TweetQueueIter();
    while(itr.hasNext()) {
      Tweet tweet = itr.next();
      if(tweet.getText().indexOf(s) == -1) {
        numTweets++;
        q.enqueue(tweet);
      }
    }

    System.out.println(numTweets + " tweets");
    return q;
  }

  public TweetQueueIter reset(Scanner fin) {

    TweetQueueIter q = new TweetQueueIter(fin);
    System.out.println(q.numTweets + " tweets");
    return q;
  }
}
