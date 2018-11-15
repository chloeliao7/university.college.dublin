public class PCQ4A {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(10);
		queue.enqueue("Ireland");
		queue.dequeue();
		queue.enqueue("England");
		queue.dequeue();
		queue.enqueue("Wales");
		queue.enqueue("Scotland");
		queue.enqueue("France");
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("Germany");
		System.out.println("\nFront item is " + queue.front());
		System.out.println("Rear item is " + queue.rear());
		System.out.println(queue.toString());
	}
}
