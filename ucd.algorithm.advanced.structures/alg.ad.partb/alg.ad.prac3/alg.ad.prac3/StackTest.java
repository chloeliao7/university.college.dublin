public class StackTest {
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        System.out.println(s);
        s.push("A");
        System.out.println(s);
        s.push("B");
        System.out.println(s);
        s.push("C");
        System.out.println(s);
        // same test for linked stack
        System.out.println("------------------");

        
        LinkedStack s1 = new LinkedStack();
        System.out.println(s1);
        s1.push("A");
        System.out.println(s1);
        s1.push("B");
        System.out.println(s1);
        s1.push("C");
        System.out.println(s1);
    }
}