package src.ll.concept.practice;

public class Main {

    public static void main(String[] args){

        LinkedList ll1 = new LinkedList(30);

        ll1.prepend(20);
        ll1.prepend(10);

        ll1.printList();
        ll1.getHead();
        ll1.getTail();
        ll1.getLength();

        ll1.removeFirst();
        ll1.removeLast();
        System.out.println();
        ll1.printList();
        ll1.getHead();
        ll1.getTail();
        ll1.getLength();

    }
}
