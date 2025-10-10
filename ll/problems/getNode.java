package src.ll.problems;

public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    if(llist==null) return 0;
    SinglyLinkedListNode fast=llist;
    SinglyLinkedListNode slow=llist;
    for(int i=0;i<=positionFromTail;i++) fast=fast.next;
    while(fast!=null){
        slow=slow.next;
        fast=fast.next;
    }
    return slow.data;
}
