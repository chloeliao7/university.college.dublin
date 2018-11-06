class ArrayQueue 
{ 
	int front, rear, size; 
	int capacity; 
	String array[]; 
	
	public ArrayQueue(int capacity) { 
		this.capacity = capacity; 
		front = this.size = 0; 
		rear = capacity - 1; 
		array = new String[this.capacity]; 
			
	} 
	
	boolean isFull(ArrayQueue queue)	{ return (queue.size == queue.capacity); } 
	boolean isEmpty(ArrayQueue queue) { return (queue.size == 0); } 
	
	void enqueue( String item) { 
		if (isFull(this)) 
			return; 
		this.rear = (this.rear + 1)%this.capacity; 
		this.array[this.rear] = item; 
		this.size = this.size + 1; 
		System.out.println(item+ " enqueued to queue"); 
	} 
	
	String dequeue() { 
		if (isEmpty(this)) 
			return null; 
		String item = this.array[this.front]; 
		this.front = (this.front + 1)%this.capacity; 
		this.size = this.size - 1; 
		return item; 
	} 
	
	String front() { 
		if (isEmpty(this)) 
			return null; 
		
		return this.array[this.front]; 
	} 
		
	String rear() { 
		if (isEmpty(this)) 
			return null; 
		return this.array[this.rear]; 
	}
	
	@Override
	public String toString() {
		return null;
	}
} 