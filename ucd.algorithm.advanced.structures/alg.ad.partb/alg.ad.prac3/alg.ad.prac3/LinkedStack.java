public class LinkedStack {
	public class Node {
		Object element;
		Node next;

		public Node(Object element) {
			this.element = element;
		}

		public String toString() {
			return element.toString();
		}
	}

	int size;
	Node top;

	public LinkedStack() {
		top = null;
		size = 0;
	}

	public void push(Object o) {
		// if the top is null
		if (top == null) {
			// create new top
			top = new Node(o);
			// set next of top to null
			top.next = null;
		} else {
			// create new node
			Node newNode = new Node(o);
			// set next of this to top
			newNode.next = top;
			// top is this new node
			top = newNode;
		}
		// increment the size
		size++;
	}

	public Object pop() {
		// remove the last element
		if (top == null)
			return null;
		// save the top object
		Object topElement = top.element;
		// move top to next
		top = top.next;
		// decrement size
		size--;
		// return the top element
		return topElement;
	}

	public Object top() {
		// remove the last element
		if (top == null)
			return null;
		// return the top
		return top.element;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// state visualization
	public String toString() {
		String output = "";
		Node node = top;
		while (node != null) {
			output = node.element.toString() + " " + output;
			node = node.next;
		}
		return "" + size + "\t" + output;
	}
}