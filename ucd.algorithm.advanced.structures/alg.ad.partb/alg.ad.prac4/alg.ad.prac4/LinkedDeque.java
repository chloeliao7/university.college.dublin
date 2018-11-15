class LinkedDeque {

	private Node front = null;
	private Node rear = null;
	private int size = 0;
	
	public void insertFirst(String value) {
		Node node = new Node();
		node.setValue(value);
		node.setNext(front);
		if(front == null) 
			rear = node;
		else
			front.setPrev(node);
		front =  node;
		size++;
	}
	
	public void insertLast(String value) {
		Node node = new Node();
		node.setValue(value);
		node.setPrev(rear);
		if(rear == null)
			front = node;
		else
			rear.setNext(node);
		rear = node;
		size++;
	}
		
	public void removeFirst() {
		if(size == 1) {
			front = null;rear = null;
			size = 0;
		} else if(size > 1) {
			front = front.getNext();
			front.setPrev(null);
			size--;
		}
	}

	public void removeLast() {
		if(size == 1) {
			front = null;rear = null;
			size = 0;
		} else if(size > 1) {
			rear = rear.getPrev();
			rear.setNext(null);
			size--;
		}
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public int size() {
		return size;
	}
	
	public Node front() {
		return front;
	}
	
	public Node rear() {
		return rear;
	}
	
	@Override
	public String toString() {
		Node node = front;
		while(node != null) {
			System.out.println(node.getValue() + "  ");
			node = node.getNext();
		}
		return null;
	}
}

class Node {
	public Node() {
		super();
	}
	
	private Node prev;
	private Node next;
	private String value;

	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}