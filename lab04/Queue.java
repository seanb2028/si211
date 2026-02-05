/*----------------------------------------------------------------
Author: Sean Beckford
This is a class that extends the functionality of the Node class
----------------------------------------------------------------*/
import java.util.*;
public class Queue {
  // integrated Node into Queue Clas
  // still inheretence just inside the Queue class
  private static class Node {
    public String data;
    public Node next;
    public Node(String d, Node n) {
      data = d;
      next = n;
    }
  }

  // declare head and tail references
  public Node head;
  public Node tail;

  public Queue() {
    // inherit the Node into the queue
    // use placeholder for Node format (string, node)
    Node N = new Node("string", null);
  }

  // adds s to the back of the queue
  public void enqueue(String s) {
    Node N = new Node(s, null);
    // base case
    if (head == null) { head = N; }
    else { tail.next = N; }
    tail = N;
  }

  // removes and returns string from the front of the queue
  public String dequeue() {
    // base case
    if (head == null) { return null; }
    Node temp = head;
    head = head.next;
    // handle a single node list
    if (head == null) { tail = null; }
    return temp.data;
  }

  // returns true if the queue is empty
  public boolean empty() {
    if (head == null) { return true; }
    else { return false; }
  }
}
