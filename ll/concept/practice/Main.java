package src.ll.concept.practice;

public class Main {

    public static void main(String[] args){

        LinkedList ll1 = new LinkedList(30);
        LinkedList ll2 = new LinkedList(300);

        ll1.printList();
//        ll1.append(20);
//        ll1.append(30);
        ll1.prepend(20);
        ll1.prepend(10);
        ll1.printList();

        ll2.printList();
//        ll2.append(200);
//        ll2.append(300);
        ll2.prepend(200);
        ll2.prepend(100);
        ll2.printList();
    }
}
