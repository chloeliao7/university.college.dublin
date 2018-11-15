public class PCQ2A_2 {
	public static void main(String[] args) {
		// the array stack
		ArrayStack arrayStack = new ArrayStack();
		System.out.println(arrayStack);
		arrayStack.push(new Character('e'));
		System.out.println(arrayStack);
		arrayStack.push(new Character('s'));
		System.out.println(arrayStack);
		arrayStack.push(new Character('s'));
		System.out.println(arrayStack);
		arrayStack.pop();
		System.out.println(arrayStack);
		arrayStack.push(new Character('s'));
		System.out.println(arrayStack);
		arrayStack.push(new Character('a'));
		System.out.println(arrayStack);
		arrayStack.pop();
		System.out.println(arrayStack);
		arrayStack.push(new Character('o'));
		System.out.println(arrayStack);
		arrayStack.push(new Character('t'));
		System.out.println(arrayStack);
		arrayStack.pop();
		System.out.println(arrayStack);
		arrayStack.push(new Character('h'));
		System.out.println(arrayStack);
		System.out.println("----------");

		System.out.println(arrayStack.toString());

	}
}
