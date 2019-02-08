import collections.LinkedList;

public class Main {


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        linkedList.removeAfter(2);

        linkedList.forEach(System.out::println);

    }
}
