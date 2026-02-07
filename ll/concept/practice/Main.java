package src.ll.concept.practice;

public class Main {

    public static void main(String[] args){

        LinkedList ll1 = new LinkedList(30);
        LinkedList ll2 = new LinkedList(300);

        ll1.prepend(20);
        ll1.prepend(10);
        ll1.insert(1,99);
        ll1.printList();
        ll1.removeFirst();
        ll1.printList();
        ll1.removeFirst();
        ll1.printList();

    }
}
