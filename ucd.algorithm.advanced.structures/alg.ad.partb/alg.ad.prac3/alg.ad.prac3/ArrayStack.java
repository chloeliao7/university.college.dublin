public class ArrayStack {
	// the array to store the stack
	Object stack[];
	// the index of the stack
	int top;
	// the default capacity
	int DEFAULT_CAPACITY = 25;

	// the constructor
	public ArrayStack() {
		// create the array
		stack = new Object[DEFAULT_CAPACITY];
		// set top
		top = 0;
	}

	// the constructor that takes one value
	public ArrayStack(int size) { // create the array
		stack = new Object[size];
		// set top
		top = 0;
	}

	public void push(Object o) { // push this
		if (top < stack.length)
			stack[top++] = o;
	}

	public Object pop() { // remove the last object
		// the top of the object to return
		// store the top of the stack
		Object o = stack[top - 1];
		// remove
		top--;
		// return
		return o;
	}

	public Object top() { // if this is empty ,return null
		if (isEmpty())
			return null;
		return stack[top - 1];
	}

	// return the size
	public int size() {
		// return the index
		return top;
	}

	public boolean isEmpty() { // return if the top is zero
		return top == 0;
	}

	public String toString() { // Print 
		String output = "";

		for (int i = 0; i < top; i++) { // iterate and add
			output = output + (stack[i] + " ");
		}
		return " " + size() + "\t" + output; // return the output

	}
}
