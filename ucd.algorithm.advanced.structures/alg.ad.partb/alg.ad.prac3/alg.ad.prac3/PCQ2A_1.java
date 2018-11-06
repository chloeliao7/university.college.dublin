public class PCQ2A_1 {
	public static void main(String[] args) {
		// the linked stack
		LinkedStack linkedStack = new LinkedStack();
		System.out.println(linkedStack);
		linkedStack.push(new Character('e'));
		System.out.println(linkedStack);
		linkedStack.push(new Character('s'));
		System.out.println(linkedStack);
		linkedStack.push(new Character('s'));
		System.out.println(linkedStack);
		linkedStack.pop();
		System.out.println(linkedStack);
		linkedStack.push(new Character('s'));
		System.out.println(linkedStack);
		linkedStack.push(new Character('a'));
		System.out.println(linkedStack);
		linkedStack.pop();
		System.out.println(linkedStack);
		linkedStack.push(new Character('o'));
		System.out.println(linkedStack);
		linkedStack.push(new Character('t'));
		System.out.println(linkedStack);
		linkedStack.pop();
		System.out.println(linkedStack);
		linkedStack.push(new Character('h'));
		System.out.println(linkedStack);
	}
}
