public class Cart {
  private Queue stuff = new Queue();

  public Queue getQueue() { return stuff; }
  
  public void add(Item it) { stuff.enqueue(it); }
    
  public double totalCost() {
    // Queue Q = cart.getQueue();
    double total = 0.0;
    Queue.Iter itr = stuff.iterator();
    while(itr.hasNext())
      total += itr.next().getPrice();
    return total;
  }

  public void printContents() {
    Queue.Iter itr = stuff.iterator();
    while(itr.hasNext())
      System.out.println(itr.next().custString());
  }

  public void buy() {
    while(!stuff.empty()) {
      System.out.println("buying ... " +
	 stuff.dequeue().getDesc());
    }
    System.out.println("Thank you for shopping!");
  }

  public void returnAll() {
    while(!stuff.empty()) {
      Item it = stuff.dequeue();
      System.out.println("returning ... "
			 + it.getDesc());
      it.incCount();
    }
  }
  
}
