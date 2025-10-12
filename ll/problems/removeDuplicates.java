package src.ll.problems;

public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
    if(llist==null) return null;
    SinglyLinkedListNode temp=llist;
    while(temp.next!=null){
        if(temp.data==temp.next.data){
            temp.next=temp.next.next;
        }else{
            temp=temp.next;
        }
    }
    return llist;
}
