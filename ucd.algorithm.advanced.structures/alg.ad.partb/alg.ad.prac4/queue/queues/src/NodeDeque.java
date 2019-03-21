/**
 * Implementation of the Deque interface by means of a doubly linked
 * list.  This class uses class DLNode, which implements a node of the list
 */

public class NodeDeque<E> implements Deque<E> {
	protected DLNode<E> header, trailer;
	protected int size;

	public NodeDeque() {
		header = new DLNode<E>();
		trailer = new DLNode<E>();
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}

	// nothing

	public int size() { return size; }

	public boolean isEmpty() {
		if (size == 0) return true;
		return false;
	}

	public E getFirst() throws EmptyDequeException {
		if (isEmpty()) throw new EmptyDequeException("Deque is empty.");
		return header.getNext().getElement();
	}

	public E getLast() throws EmptyDequeException {
		if (isEmpty()) throw new EmptyDequeException("Deque is empty.");
		return trailer.getPrev().getElement();
	}

	public void addFirst(E o) {
		DLNode<E> second = header.getNext();
		DLNode<E> first = new DLNode<E>(o, header, second);
		second.setPrev(first);
		header.setNext(first);
		size++;
	}

	public void addLast(E o) {
		DLNode<E> secondtolast = trailer.getPrev();
		DLNode<E> last = new DLNode<E>(o, secondtolast, trailer);
		secondtolast.setNext(last);
		trailer.setPrev(last);
		size++;
	}

	public E removeFirst() throws EmptyDequeException {
		if (isEmpty()) throw new EmptyDequeException("Deque is empty.");
		DLNode<E> first = header.getNext();
		E o = first.getElement();
		DLNode<E> second = first.getNext();
		header.setNext(second);
		second.setPrev(header);
		size--;
		return o;
	}

	public E removeLast() throws EmptyDequeException {
		if (isEmpty()) throw new EmptyDequeException("Deque is empty.");
		DLNode<E> last = trailer.getPrev();
		E o = last.getElement();
		DLNode<E> secondtolast = last.getPrev();
		trailer.setPrev(secondtolast);
		secondtolast.setNext(trailer);
		size--;
		return o;
	}
}
