import java.util.*;

public class HW1
{  
  public static void main(String[] args)
  {
    Random rand = new Random(System.currentTimeMillis());
    TreeSet<Integer> tr = new TreeSet<Integer>();
    for(int i = 0; i < 10; i++)
      tr.add(rand.nextInt(1000));
    
    Iterator<Integer> i = tr.iterator();

    while (i.hasNext()) {
        System.out.println(i.next());
    }
  }
}