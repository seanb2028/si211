// Author: Sean Beckford
public class Queue
{
  public void enqueue(String s)
  {
    if (head == null) 
      head = tail = new Node(s,null);
    else 
    { 
      tail.next = new Node(s,null); 
      tail = tail.next; 
    }
  }

  public String dequeue() throws NullPointerException
  { 
    if (head == null) { throw new NullPointerException("dequeue empty queue"); }
    Node t = head; 
    head = head.next;
    if (head == null)
      tail = null;
    return t.data;
  }
  
  public boolean empty() { return head == null; }

  public Iter iterator() { return new Iter(head); }

  protected class Iter
  {
    private Node curr;
    public Iter(Node start) throws NullPointerException { 
      if (start == null) { throw new NullPointerException("iterator past end of queue"); }
      curr = start; 
    }
    public boolean hasNext() { return curr != null; }
    public String next() 
    { 
      String s = curr.data; 
      curr = curr.next;  
      return s; 
    }
  }

  private class Node
  {
    public String data;
    public Node next;
    public Node(String d, Node n) { data = d; next = n; }
  }
  
  private Node head = null, tail = null;
}
