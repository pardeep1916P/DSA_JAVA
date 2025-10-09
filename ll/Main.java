package src.ll;

public class Main {
    public static void main(String[] args){
        System.out.println("insert:");
        System.out.println("--------------------------------- ");
        LinkedList ll1=new LinkedList(1);
        LinkedList ll2=new LinkedList(5);
        ll1.append(2);
        ll1.append(3);
        ll2.append(6);
        ll2.append(7);
        ll2.prepend(4);
        ll1.prepend(0);
        ll1.printList();
        System.out.println("insert 888 at index 0 : "+ll1.insert(0,888));
        ll1.printList();
        System.out.println("------------------ ");
        ll2.printList();
        System.out.println("insert 888 at index 1 : "+ll2.insert(1,888));
        ll2.printList();
        System.out.println("--------------------------------- ");
    }
}
