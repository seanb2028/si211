/*----------------------------------------------------------------
Author: Sean Beckford
This is a class that extends the functionality of the Node class
----------------------------------------------------------------*/
import java.util.*;

public class myQueue {
  // integrated Node into Queue Clas
  // still inheritance just inside the Queue class
  private static class Node {
    public Section data;
    public Node next;
    public Node(Section d, Node n) {
      data = d;
      next = n;
    }
  }

  // declare head and tail references
  public Node head;
  public Node tail;

  public myQueue() {
    // inherit the Node into the queue
    // use placeholder for Node format (Section, node)
    Section s = new Section();
    Node N = new Node(s, null);
  }

  // adds s to the back of the queue
  public void enqueue(Section s) {
    Node N = new Node(s, null);
    // base case
    if (head == null) { head = N; }
    else { tail.next = N; }
    tail = N;
  }

  // removes and returns string from the front of the queue
  public Section dequeue() {
    // base case
    if (head == null) { return null; }
    Node temp = head;
    head = head.next;
    // handle a single node list
    if (head == null) { tail = null; }
    return temp.data;
  }

  public Iter iterator() { return new Iter(head); }

  // iterator to cycle through Queue w/o messing with it
  protected class Iter {
    private Node curr;
    public Iter(Node start) { curr = start; }
    public boolean hasNext() { return curr != null; }
    public Section next() {
      Section s = curr.data;
      curr = curr.next;
      return s;
    }
  }

  // returns true if the queue is empty
  public boolean empty() { return head == null; }
}
