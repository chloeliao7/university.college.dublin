public class PCQ3L_2 {
	public static void main(String[] args) {
		// the array stack
		ArrayStack arrayStack = new ArrayStack();
		System.out.println(arrayStack);
		arrayStack.push("Ireland");
		System.out.println(arrayStack);
		arrayStack.pop();
		System.out.println(arrayStack);
		arrayStack.push("England");
		System.out.println(arrayStack);
		arrayStack.pop();
		System.out.println(arrayStack);
		arrayStack.push("Wales");
		System.out.println(arrayStack);
		arrayStack.pop();
		System.out.println(arrayStack);
		arrayStack.push("Scotland");
		System.out.println(arrayStack);
		arrayStack.pop();
		System.out.println(arrayStack);
		arrayStack.push("France");
		System.out.println(arrayStack);
		arrayStack.push("Germany");
		System.out.println(arrayStack);
		System.out.println("----------");
		
		System.out.println(arrayStack.toString());
	}
}
