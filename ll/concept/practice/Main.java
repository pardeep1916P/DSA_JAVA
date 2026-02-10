package src.ll.concept.practice;

public class Main {

    public static void main(String[] args){

        LinkedList ll1 = new LinkedList(30);

        ll1.prepend(20);
        ll1.prepend(10);

        ll1.printList();
        System.out.println();
        System.out.print("removed Node : "+ ll1.remove(1).value);
        ll1.printList();

    }
}
