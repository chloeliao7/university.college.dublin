public class ArrayQueue<E> implements Queue<E> {
	int front, rear, size;
	int capacity;
	E array[];

	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		array = (E[]) new Object[this.capacity];
	}

	boolean isFull(ArrayQueue queue) { return (queue.size == queue.capacity); }
	boolean isEmpty(ArrayQueue queue) { return (queue.size == 0); }

	public void enqueue(E item) {
		if (isFull(this)) return;
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item + " enqueued to queue");
	}

	public E dequeue() throws EmptyQueueException {
		if (isEmpty(this)) return null;
		E item = (E)this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	public E front() throws EmptyQueueException {
		if (isEmpty(this)) return null;
		return this.array[this.front];
	}

	E rear() {
		if (isEmpty(this)) return null;
		return this.array[this.rear];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ArrayQueue is ");
		for (E data : array) { sb.append(data + " "); }
		return sb.toString();
	}
}