public class PCQ3L_1 {
	public static void main(String args[]) {
		// the linked stack
		LinkedStack linkedStack = new LinkedStack();
		System.out.println(linkedStack);
		linkedStack.push("Ireland");
		System.out.println(linkedStack);
		linkedStack.pop();
		System.out.println(linkedStack);
		linkedStack.push("England");
		System.out.println(linkedStack);
		linkedStack.pop();
		System.out.println(linkedStack);
		linkedStack.push("Wales");
		System.out.println(linkedStack);
		linkedStack.pop();
		System.out.println(linkedStack);
		linkedStack.push("Scotland");
		System.out.println(linkedStack);
		linkedStack.pop();
		System.out.println(linkedStack);
		linkedStack.push("France");
		System.out.println(linkedStack);
		linkedStack.push("Germany");
		System.out.println(linkedStack);
	}
}
