package src.ll.concept;

public class Main {
    public static void main(String[] args){
        System.out.println("-------------------------------- ");
        System.out.println("reverse");
        System.out.println("-------------------------------- ");
        LinkedList ll1=new LinkedList(1);
        LinkedList ll2=new LinkedList(5);
        ll1.append(2);
        ll1.append(3);
        ll2.append(6);
        ll2.append(7);
        ll2.prepend(4);
        ll1.prepend(0);
        System.out.print("list1 : ");
        ll1.printList();
        ll1.reverse();
        System.out.print("reversed list1 : ");
        ll1.printList();
        System.out.print("list2 : ");
        ll2.printList();
        System.out.print("reversed list2 : ");
        ll2.printList();
    }
}
