package src.ll.problems;

//helper method to delete first node
public static SinglyLinkedListNode deleteFirst(SinglyLinkedListNode head){
    if(head==null) return head;
    SinglyLinkedListNode temp=head;
    head=head.next;
    temp.next=null;
    return head;
}

//helper method to delete last node
public static SinglyLinkedListNode deleteLast(SinglyLinkedListNode head,int size){
    if(head==null) return head;
    SinglyLinkedListNode temp=head;
    SinglyLinkedListNode pre=head;
    while(temp.next!=null){
        pre=temp;
        temp=temp.next;
    }
    pre.next=null;
    size--;
    if(size==0){
        head=null;
    }
    return head;

}

//helper method to get size of ll
public static int getSize(SinglyLinkedListNode head){
    if(head==null) return 0;
    SinglyLinkedListNode temp=head;
    int size=0;
    while(temp!=null){
        size++;
        temp=temp.next;
    }
    return size;
}

public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    int size=getSize(llist);
    if(position<0 || position>=size) return null;
    else if(position==0){
        return deleteFirst(llist);
    }else if(position==size-1){
        return deleteLast(llist,size);
    }else{
        SinglyLinkedListNode temp=llist;
        SinglyLinkedListNode pre=llist;
        for(int i=0;i<position-1;i++) pre=pre.next;
        temp=pre.next;
        pre.next=temp.next;

    }
    return llist;
}