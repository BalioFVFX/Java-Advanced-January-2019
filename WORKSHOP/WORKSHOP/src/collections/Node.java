package collections;

public class Node {
    Node prev;
    Node next;
    int value;

    public Node(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }
}
