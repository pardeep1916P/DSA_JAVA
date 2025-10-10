package src.ll.problems;

public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    if(llist==null) return null;
    SinglyLinkedListNode before=null;
    SinglyLinkedListNode temp=llist;
    SinglyLinkedListNode after=llist;
    while(temp!=null){
        after=temp.next;
        temp.next=before;
        before=temp;
        temp=after;
    }
    return before;

}
