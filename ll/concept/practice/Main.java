package src.ll.concept.practice;

public class Main {

    public static void main(String[] args){

        LinkedList ll1 = new LinkedList(30);
        ll1.printList();
        ll1.removeLast();
        ll1.printList();
        System.out.print(ll1.removeLast());
        ll1.prepend(20);
        ll1.prepend(10);
        ll1.printList();
        ll1.removeLast();
        ll1.printList();

    }
}
