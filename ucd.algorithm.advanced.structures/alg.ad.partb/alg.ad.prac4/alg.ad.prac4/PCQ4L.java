public class TestLinkedDeque {
  public static void main(String[] args) {
    LinkedDeque linkedDeque = new LinkedDeque();
    linkedDeque.insertFirst("Ireland");
    linkedDeque.removeLast();
    linkedDeque.insertLast("England");
    linkedDeque.removeFirst();
    linkedDeque.insertLast("Wales");
    linkedDeque.insertFirst("Scotland");
    linkedDeque.insertLast("France");
    linkedDeque.removeFirst();
    linkedDeque.removeLast();
    linkedDeque.insertLast("Germany");
    linkedDeque.toString();
  }
}