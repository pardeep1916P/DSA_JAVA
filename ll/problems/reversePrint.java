package src.ll.problems;
public static void reversePrint(SinglyLinkedListNode llist) {
    if(llist==null) return ;
    reversePrint(llist.next);
    System.out.println(llist.data);
}