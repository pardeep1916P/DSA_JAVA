package src.ll;

public class Main {
    public static void main(String[] args){
        System.out.println("remove:");
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
        System.out.println("removed node with value : "+ll1.remove(0).value);
        ll1.printList();
        System.out.println("--------------------");
        ll2.printList();
        System.out.println("removed node with value :  "+ll2.remove(1).value);
        ll2.printList();
        System.out.println("--------------------------------- ");
    }
}
