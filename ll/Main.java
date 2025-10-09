package src.ll;

public class Main {
    public static void main(String[] args){
        System.out.println("set:");
        LinkedList ll1=new LinkedList(1);
        LinkedList ll2=new LinkedList(5);
        ll1.append(2);
        ll1.append(3);
        ll2.append(6);
        ll2.append(7);
        ll2.prepend(4);
        ll1.prepend(0);
        ll1.printList();
        System.out.println("setting index 2 value to 99: "+ll1.set(2,99));
        ll1.printList();
        ll2.printList();
        System.out.println("setting index 1 value to 99: "+ll2.set(1,99));
        ll2.printList();
    }
}
