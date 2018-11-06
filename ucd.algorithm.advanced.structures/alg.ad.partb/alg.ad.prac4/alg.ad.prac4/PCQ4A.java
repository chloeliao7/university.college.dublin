public class TestArrayQueue {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(1000);
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
	}
}
