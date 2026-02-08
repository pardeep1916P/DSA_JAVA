package src.ll.concept.practice;

public class Main {

    public static void main(String[] args){

        LinkedList ll1 = new LinkedList(30);

        ll1.prepend(20);
        ll1.prepend(10);

        ll1.printList();
        System.out.println();
        System.out.println("update 30->40 : "+ll1.set(2,40));
        ll1.printList();
        System.out.println();
        System.out.println("out of bounds testing : "+ll1.set(3,12));
        ll1.printList();

    }
}
