
public interface Queue<E> {
  public int size();
  public boolean isEmpty();
  public E front() throws EmptyQueueException; // checks if at front of the queue
  public void enqueue(E element);
  public E dequeue() throws EmptyQueueException; // removes from front of the queue
}