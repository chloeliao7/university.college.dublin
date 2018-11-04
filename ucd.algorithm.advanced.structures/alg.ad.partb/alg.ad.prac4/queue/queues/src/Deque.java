/**
 * Interface for a deque: a collection of objects that are inserted
 * and removed at both ends; a subset of java.util.LinkedList methods.
 */

public interface Deque<E> {
   // Returns the number of elements in the deque.
  public int size();
  public boolean isEmpty();
  public E getFirst() throws EmptyDequeException;
  public E getLast() throws EmptyDequeException;
  public void addFirst(E element);
  public void addLast(E element);
  public E removeFirst() throws EmptyDequeException;
  public E removeLast() throws EmptyDequeException;
}